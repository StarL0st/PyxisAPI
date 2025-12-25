package com.starl0stgaming.pyxisapi.data.node.loader;

import com.starl0stgaming.pyxisapi.PyxisAPI;
import com.starl0stgaming.pyxisapi.data.node.PyxisNode;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Map;

public class PyxisNodeLoader extends SimpleJsonResourceReloadListener<PyxisNode> {

    public PyxisNodeLoader() {
        super(
                PyxisNode.CODEC,
                FileToIdConverter.json(
                        PyxisAPI.MODID + "/node"
                )
        );
    }

    @Override
    protected void apply(Map<ResourceLocation, PyxisNode> map, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        PyxisAPI.NODE_REGISTRY.onReload(map);
        map.forEach((k,v)->{
            PyxisAPI.LOGGER.info("Node "+ k.toString() +" has been loaded");
        });
    }
}
