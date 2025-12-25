package com.starl0stgaming.pyxisapi.data.node.validation;

import com.starl0stgaming.pyxisapi.PyxisAPI;
import com.starl0stgaming.pyxisapi.data.node.interaction.PyxisInteractionType;
import com.starl0stgaming.pyxisapi.data.node.type.data.PyxisType;
import com.starl0stgaming.pyxisapi.data.node.validation.exception.PyxisInvalidInteractionException;
import com.starl0stgaming.pyxisapi.data.node.validation.exception.PyxisInvalidStateException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PyxisTypeValidator {

    public static void validateType(PyxisType type) {
        //first validate type data, then compare
        // TODO: Make from dynamic interaction registry instead (maximum interactions)
        if(type.interactions().size() != 1) throw new PyxisInvalidInteractionException(
                "Invalid interaction count for type '" + type.name() +
                        "': expected exactly 1, got " + type.interactions().size()
        );
        //TODO: compute list a single time
        //Check interactions
        if(Arrays.stream(PyxisInteractionType.values())
                .noneMatch(match -> match.id().equalsIgnoreCase(type.interactions().get(0).id()))) throw new PyxisInvalidInteractionException(
                "Invalid interaction for type '" + type.name() + "', got: '" + type.interactions().get(0) + "'. " +
                        "Expected any of: " + Arrays.stream(PyxisInteractionType.values())
                        .map(PyxisInteractionType::id)
                        .collect(Collectors.joining(", ")));

        //Check states
        type.states().forEach(pyxisTypeState -> {
            switch (pyxisTypeState.type()) {
                case "enum" -> {
                    if (pyxisTypeState.values().isEmpty()) throw new PyxisInvalidStateException(
                            "Expected 'values' to not be empty since state type is 'enum'"
                    );
                    if (pyxisTypeState.defaultState().isEmpty()) throw new PyxisInvalidStateException(
                            "Expected 'default' to not be empty since declared type is 'enum'"
                    );
                    if (!pyxisTypeState.values().get().contains(pyxisTypeState.defaultState().get()))
                        throw new PyxisInvalidStateException(
                                "Expected declared 'default' (" + pyxisTypeState.defaultState().get() + ") state to be in declared 'values' states"
                        );
                }
                case "bool" -> {
                    if (pyxisTypeState.defaultState().isEmpty()) throw new PyxisInvalidStateException(
                            "State 'bool' must declare a default state"
                    );
                    String def = pyxisTypeState.defaultState().get().toLowerCase();
                    if (!def.equals("true") && !def.equals("false")) {
                        throw new PyxisInvalidStateException(
                                "bool state 'default' must be 'true' or 'false', got: " + def
                        );
                    }
                }
                case "int" -> {
                    String defaultVal = pyxisTypeState.defaultState()
                            .orElseThrow(() -> new PyxisInvalidStateException(
                                    "Int state must define a default state"
                            ));

                    int parsed;
                    try {
                        parsed = Integer.parseInt(defaultVal);
                    } catch (NumberFormatException e) {
                        throw new PyxisInvalidStateException(
                                "Invalid integer default state: " + defaultVal
                        );
                    }
                }
                case "float" -> {
                    String defaultVal = pyxisTypeState.defaultState()
                            .orElseThrow(() -> new PyxisInvalidStateException(
                                    "Float state must define a default state"
                            ));

                    float parsed;
                    try {
                        parsed = Float.parseFloat(defaultVal);
                    } catch (NumberFormatException e) {
                        throw new PyxisInvalidStateException(
                                "Invalid float default state: " + defaultVal
                        );
                    }
                }
                default -> throw new PyxisInvalidStateException(
                        "Unknown state type: " + type.name()
                );
            }
        });
        PyxisAPI.LOGGER.info("[Pyxis Type Validator] Pyxis Node type " + type.name() + " passed validation checks");
    }
}
