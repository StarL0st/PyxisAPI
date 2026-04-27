package com.starl0stgaming.pyxisapi.data.node.type.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.starl0stgaming.pyxisapi.data.node.interaction.PyxisInteractionType;
import com.starl0stgaming.pyxisapi.data.node.type.data.state.PyxisTypeState;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.Map;
import java.util.Set;

public record PyxisType(
        Identifier name,
        List<PyxisInteractionType> interactions, //click, drag, scroll, hold
        List<PyxisTypeState> states
) {
    public static final Codec<PyxisType> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Identifier.CODEC.fieldOf("type").forGetter(PyxisType::name),
                    Codec.list(PyxisInteractionType.CODEC).fieldOf("interactions").forGetter(PyxisType::interactions),
                    PyxisTypeState.CODEC.listOf().fieldOf("states").forGetter(PyxisType::states)
            ).apply(instance, PyxisType::new)
    );

}
