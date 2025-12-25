package com.starl0stgaming.pyxisapi.data.node.interaction;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.starl0stgaming.pyxisapi.util.PyxisUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;

import java.util.Optional;

public record PyxisNodeHitbox(
        ResourceLocation id,
        PyxisInteractionType interaction,
        AABB hitbox,
        //Optional<HitboxCondition> when,
        String onInteract


) {
    public static final Codec<PyxisNodeHitbox> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
                ResourceLocation.CODEC.fieldOf("id").forGetter(PyxisNodeHitbox::id),
                PyxisInteractionType.CODEC.fieldOf("interaction").forGetter(PyxisNodeHitbox::interaction),
                PyxisUtil.AABB_CODEC.fieldOf("aabb").forGetter(PyxisNodeHitbox::hitbox),
                Codec.STRING.fieldOf("on_interact").forGetter(PyxisNodeHitbox::onInteract)
        ).apply(instance, PyxisNodeHitbox::new)
    );
}
