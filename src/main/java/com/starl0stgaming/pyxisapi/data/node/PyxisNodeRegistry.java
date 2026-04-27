package com.starl0stgaming.pyxisapi.data.node;

import com.starl0stgaming.pyxisapi.PyxisAPI;
import com.starl0stgaming.pyxisapi.data.handle.PyxisNodeDefinition;
import com.starl0stgaming.pyxisapi.data.node.validation.PyxisNodeValidator;
import com.starl0stgaming.pyxisapi.data.node.validation.exception.PyxisInvalidTypeException;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.event.level.LevelEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PyxisNodeRegistry {
    private HashMap<Identifier, PyxisNodeDefinition> nodes;

    public PyxisNodeRegistry() {
        this.nodes = new HashMap<>();
        this.init();
    }

    private void init() {

    }

    public void onReload(Map<Identifier, PyxisNode> map) {
        if(!this.validateData(map)) return;
        this.propagateUpdate();
    }

    private boolean validateData(Map<Identifier, PyxisNode> map) {
        try {
            Map<Identifier, PyxisNodeDefinition> temp = map.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> PyxisNodeValidator.validateNodes(e.getValue())
                    ));
            this.nodes.clear();
            this.nodes.putAll(temp);
            return true;
        } catch (PyxisInvalidTypeException e) {
            PyxisAPI.LOGGER.error("Failed to validate Pyxis nodes: {}", e.getMessage(), e);
            return false;
        }
    }

    private void propagateUpdate() {

    }

    public static void onLevelLoad(LevelEvent.Load event) {
        PyxisAPI.LOGGER.info("[PyxisAPI] Loaded level event");
    }

    public HashMap<Identifier, PyxisNodeDefinition> getNodeMap() {
        return nodes;
    }
}
