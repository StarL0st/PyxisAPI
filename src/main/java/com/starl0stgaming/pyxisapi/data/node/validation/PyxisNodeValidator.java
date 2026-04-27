package com.starl0stgaming.pyxisapi.data.node.validation;

import com.starl0stgaming.pyxisapi.PyxisAPI;
import com.starl0stgaming.pyxisapi.data.handle.PyxisNodeDefinition;
import com.starl0stgaming.pyxisapi.data.handle.PyxisTypeHandle;
import com.starl0stgaming.pyxisapi.data.handle.type.EnumStateDef;
import com.starl0stgaming.pyxisapi.data.node.PyxisNode;
import com.starl0stgaming.pyxisapi.data.node.validation.exception.PyxisInvalidNodeException;
import com.starl0stgaming.pyxisapi.data.node.validation.exception.PyxisInvalidStateException;

public class PyxisNodeValidator {
    public static PyxisNodeDefinition validateNodes(PyxisNode node) {
        if(node.meta().node().toString().isBlank()) throw new PyxisInvalidNodeException(
                "Field 'node' for a node is empty! Check declarations, can't specify without 'node' declared"
        );

        if(node.meta().name().isBlank()) throw new PyxisInvalidNodeException(
                "Field 'name' for a node is empty! Check declarations, can't specify without 'name' declared"
        );

        if(!PyxisAPI.TYPE_REGISTRY.getTypeMap().containsKey(node.meta().type())) throw new PyxisInvalidStateException(
                "Declared type ('" + node.meta().type() + "') for node '" + node.meta().name() + "' does not exist!"
        );

        PyxisTypeHandle nodeType = PyxisAPI.TYPE_REGISTRY.getType(node.meta().type());
        nodeType.getStates().forEach((s, pyxisStateDef) -> {
            if(pyxisStateDef instanceof EnumStateDef def) {
                for(String value : def.getValues()) {
                    if(!node.render().states().containsKey(value)) throw new PyxisInvalidNodeException(
                            "Node '" + node.meta().name() + "' is missing render state '" +
                                    value + "' for enum state '" + s + "'. " +
                                    "Expected: " + def.getValues() +
                                    ", Found: " + node.render().states().keySet()
                    );
                }
                return;
            }

            //non-enum
            if(!node.render().states().containsKey(pyxisStateDef.name())) throw new PyxisInvalidNodeException(
                    "Expected node '" + node.meta().name() + "' to contain states: '" + pyxisStateDef.name() +
                            "' but only found: '" + node.render().states().keySet() + "' "
            );
        });

        //TODO: Check against model & renderer registry for valid data

        //Check hitbox interactions
        var typeInteractions = nodeType.getInteractions();
        node.hitboxes().forEach(hitbox -> {
            if(typeInteractions.contains(hitbox.interaction().id())) throw new PyxisInvalidNodeException(
                "Invalid hitbox ('" + hitbox.id() + "') interaction registered for node type, expected: '" + typeInteractions + "', got: '" +
                hitbox.interaction().id() + "' "
            );
        });

        //TODO: add event validation
        PyxisAPI.LOGGER.info("[Pyxis Node Validator] Pyxis Node " + node.meta().name() + " passed validation checks");
        return new PyxisNodeDefinition(
                node.meta().node(),
                node.meta().type(),
                node.render().states(),
                node.hitboxes()
        );

    }
}
