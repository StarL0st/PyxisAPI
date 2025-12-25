package com.starl0stgaming.pyxisapi.data.node.loader;

import com.starl0stgaming.pyxisapi.PyxisAPI;
import com.starl0stgaming.pyxisapi.data.node.type.data.PyxisType;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class PyxisTypeLoader extends SimpleJsonResourceReloadListener<PyxisType> {

    public PyxisTypeLoader() {
        super(
                PyxisType.CODEC,
                FileToIdConverter.json(PyxisAPI.MODID + "/node_types")
        );
    }

    @Override
    protected void apply(@NotNull Map<ResourceLocation, PyxisType> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        PyxisAPI.TYPE_REGISTRY.onReload(map);
        map.forEach((k,v) -> {
            PyxisAPI.LOGGER.info("Node Type {} has been loaded", k.toString());
        });
    }
}
