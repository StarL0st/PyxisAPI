package com.starl0stgaming.pyxisapi.data.node.behavior.action;

import com.starl0stgaming.pyxisapi.data.node.PyxisNodeInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public record PyxisExternalActionContext(Level level, BlockPos pos, Player player, PyxisNodeInstance nodeInstance) {
}
