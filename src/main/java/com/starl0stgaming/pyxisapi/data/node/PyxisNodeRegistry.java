package com.starl0stgaming.pyxisapi.data.node;

import com.starl0stgaming.pyxisapi.PyxisAPI;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.event.level.LevelEvent;

import java.util.HashMap;
import java.util.Map;

public class PyxisNodeRegistry {
    private HashMap<ResourceLocation, PyxisNode> nodes;

    public PyxisNodeRegistry() {
        this.nodes = new HashMap<>();
        this.init();
    }

    private void init() {

    }

    public void onReload(Map<ResourceLocation, PyxisNode> map) {
        if(!this.validateData(map)) return;
        this.nodes.clear();
        this.nodes.putAll(map);
        this.propagateUpdate();
    }

    private boolean validateData(Map<ResourceLocation, PyxisNode> map) {

        return false;
    }

    private void propagateUpdate() {

    }

    public static void onLevelLoad(LevelEvent.Load event) {
        PyxisAPI.LOGGER.info("[PyxisAPI] Loaded level event");
    }

    public HashMap<ResourceLocation, PyxisNode> getNodeMap() {
        return nodes;
    }
}
