package com.starl0stgaming.pyxisapi.data.node;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.starl0stgaming.pyxisapi.data.node.interaction.PyxisNodeHitbox;
import com.starl0stgaming.pyxisapi.data.node.state.PyxisNodeStateRender;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record PyxisNode(
    PyxisNodeMeta meta,
    PyxisNodeStateRender render,
    List<PyxisNodeHitbox> hitboxes
) {

    public static final Codec<PyxisNode> CODEC = RecordCodecBuilder.create(pyxisNodeInstance ->
            pyxisNodeInstance.group(
                    PyxisNodeMeta.CODEC.fieldOf("meta").forGetter(PyxisNode::meta),
                    PyxisNodeStateRender.CODEC.fieldOf("render").forGetter(PyxisNode::render),
                    PyxisNodeHitbox.CODEC.listOf().fieldOf("hitbox").forGetter(PyxisNode::hitboxes)
            ).apply(pyxisNodeInstance, PyxisNode::new)
    );

    public record PyxisNodeMeta(
            ResourceLocation node,
            String name,
            ResourceLocation type
    ) {
        public static final Codec<PyxisNodeMeta> CODEC = RecordCodecBuilder.create(pyxisNodeMetaInstance ->
                pyxisNodeMetaInstance.group(
                        ResourceLocation.CODEC.fieldOf("node").forGetter(PyxisNodeMeta::node),
                        Codec.STRING.fieldOf("name").forGetter(PyxisNodeMeta::name),
                        ResourceLocation.CODEC.fieldOf("type").forGetter(PyxisNodeMeta::type)
                ).apply(pyxisNodeMetaInstance, PyxisNodeMeta::new));
    }
}
