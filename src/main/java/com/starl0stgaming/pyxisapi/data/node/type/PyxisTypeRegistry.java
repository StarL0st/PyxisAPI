package com.starl0stgaming.pyxisapi.data.node.type;

import com.starl0stgaming.pyxisapi.PyxisAPI;
import com.starl0stgaming.pyxisapi.data.handle.PyxisTypeHandle;
import com.starl0stgaming.pyxisapi.data.node.type.data.PyxisType;
import com.starl0stgaming.pyxisapi.data.node.validation.PyxisTypeValidator;
import com.starl0stgaming.pyxisapi.data.node.validation.exception.PyxisInvalidTypeException;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.event.level.LevelEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PyxisTypeRegistry {
    private final HashMap<ResourceLocation, PyxisTypeHandle> types;

    //validation

    public PyxisTypeRegistry() {
        this.types = new HashMap<>();
        this.init();
    }

    private void init() {

    }

    public void onReload(Map<ResourceLocation, PyxisType> map) {
        if(!this.validateData(map)) return;
        this.propagateUpdate();
    }

    private boolean validateData(Map<ResourceLocation, PyxisType> map) {
        try {
            Map<ResourceLocation, PyxisTypeHandle> temp = map.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> PyxisTypeValidator.validateType(e.getValue())
                    ));
            this.types.clear();
            this.types.putAll(temp);
            return true;
        } catch (PyxisInvalidTypeException e) {
            PyxisAPI.LOGGER.error("Failed to validate Pyxis types: {}", e.getMessage(), e);
            return false;
        }
    }

    private void propagateUpdate() {

    }

    public static void onLevelLoad(LevelEvent.Load event) {
        PyxisAPI.LOGGER.info("[PyxisAPI] Loaded level event");
    }

    public HashMap<ResourceLocation, PyxisTypeHandle> getTypeMap() {
        return types;
    }

    public PyxisTypeHandle getType(ResourceLocation resourceLocation) {
        return this.types.get(resourceLocation);
    }
}
