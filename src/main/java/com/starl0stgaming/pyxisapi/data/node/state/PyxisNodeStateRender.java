package com.starl0stgaming.pyxisapi.data.node.state;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.Optional;

public record PyxisNodeStateRender(
        Map<String, PyxisStateRenderInfo> states
) {
    public static Codec<PyxisNodeStateRender> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
                Codec.unboundedMap(Codec.STRING, PyxisStateRenderInfo.CODEC).fieldOf("states").forGetter(PyxisNodeStateRender::states)
        ).apply(instance, PyxisNodeStateRender::new)
    );

    public record PyxisStateRenderInfo(
            ResourceLocation model,
            Optional<ResourceLocation> custom_renderer
    ) {
        public static final Codec<PyxisStateRenderInfo> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        ResourceLocation.CODEC.fieldOf("model").forGetter(PyxisStateRenderInfo::model),
                        ResourceLocation.CODEC.optionalFieldOf("custom_renderer").forGetter(PyxisStateRenderInfo::custom_renderer)
                ).apply(instance, PyxisStateRenderInfo::new)
        );
    }
}
