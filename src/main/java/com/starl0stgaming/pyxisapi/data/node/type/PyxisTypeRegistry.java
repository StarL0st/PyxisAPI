package com.starl0stgaming.pyxisapi.data.node.type;

import com.starl0stgaming.pyxisapi.PyxisAPI;
import com.starl0stgaming.pyxisapi.data.node.type.data.PyxisType;
import com.starl0stgaming.pyxisapi.data.node.validation.PyxisTypeValidator;
import com.starl0stgaming.pyxisapi.data.node.validation.exception.PyxisInvalidTypeException;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.event.level.LevelEvent;

import java.util.HashMap;
import java.util.Map;

public class PyxisTypeRegistry {
    private final HashMap<ResourceLocation, PyxisType> types;

    //validation

    public PyxisTypeRegistry() {
        this.types = new HashMap<>();
        this.init();
    }

    private void init() {

    }

    public void onReload(Map<ResourceLocation, PyxisType> map) {
        if(!this.validateData(map)) return;
        this.types.clear();
        this.types.putAll(map);
        this.propagateUpdate();
    }

    private boolean validateData(Map<ResourceLocation, PyxisType> map) {
        try {
            map.values().forEach(PyxisTypeValidator::validateType);
            return true;
        } catch (PyxisInvalidTypeException e) {
            return false;
        }
    }

    private void propagateUpdate() {

    }

    public static void onLevelLoad(LevelEvent.Load event) {
        PyxisAPI.LOGGER.info("[PyxisAPI] Loaded level event");
    }

    public HashMap<ResourceLocation, PyxisType> getTypeMap() {
        return types;
    }
}
