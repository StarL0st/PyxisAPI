package com.starl0stgaming.pyxisapi.data.node.interaction.event.events;

import com.starl0stgaming.pyxisapi.data.node.PyxisNodeInstance;
import com.starl0stgaming.pyxisapi.data.node.interaction.PyxisNodeHitbox;
import net.minecraft.world.entity.player.Player;

public record PyxisHitboxInteractEvent(
        PyxisNodeInstance node,
        PyxisNodeHitbox hitbox,
        Player player
) implements PyxisEvent {
    @Override
    public PyxisEventType type() {
        return PyxisEventType.HITBOX_INTERACT;
    }
}
