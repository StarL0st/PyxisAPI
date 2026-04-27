package com.starl0stgaming.pyxisapi.data.node.interaction;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.starl0stgaming.pyxisapi.util.PyxisUtil;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.AABB;

import java.util.Optional;

public record PyxisNodeHitbox(
        Identifier id,
        PyxisInteractionType interaction,
        AABB hitbox,
        //Optional<HitboxCondition> when,
        Identifier onInteract


) {
    public static final Codec<PyxisNodeHitbox> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
                Identifier.CODEC.fieldOf("id").forGetter(PyxisNodeHitbox::id),
                PyxisInteractionType.CODEC.fieldOf("interaction").forGetter(PyxisNodeHitbox::interaction),
                PyxisUtil.AABB_CODEC.fieldOf("aabb").forGetter(PyxisNodeHitbox::hitbox),
                Identifier.CODEC.fieldOf("on_interact").forGetter(PyxisNodeHitbox::onInteract)
        ).apply(instance, PyxisNodeHitbox::new)
    );
}
