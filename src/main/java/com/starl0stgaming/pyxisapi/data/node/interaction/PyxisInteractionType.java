package com.starl0stgaming.pyxisapi.data.node.interaction;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum PyxisInteractionType {
    CLICK("click"),
    DRAG("drag"),
    SCROLL("scroll"),
    HOLD("hold");

    private final String id;

    PyxisInteractionType(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }

    public static final Codec<PyxisInteractionType> CODEC =
            Codec.STRING.comapFlatMap(
                    s -> Arrays.stream(values())
                            .filter(v -> v.id.equals(s))
                            .findFirst()
                            .map(DataResult::success)
                            .orElseGet(() -> DataResult.error(() -> "Unknown Interaction: " + s)),
                    PyxisInteractionType::id
            );
}
