package com.starl0stgaming.pyxisapi.data.node.type.data.state;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record PyxisTypeState(
        String id,
        String type, // "bool", "int", "float", "enum",
        Optional<List<String>> values,
        Optional<String> defaultState
) {
    public static final Codec<PyxisTypeState> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
                Codec.STRING.fieldOf("id").forGetter(PyxisTypeState::id),
                Codec.STRING.fieldOf("type").forGetter(PyxisTypeState::type),
                Codec.list(Codec.STRING).optionalFieldOf("values").forGetter(PyxisTypeState::values),
                Codec.STRING.optionalFieldOf("default").forGetter(PyxisTypeState::defaultState)
        ).apply(instance, PyxisTypeState::new)
    );
}
