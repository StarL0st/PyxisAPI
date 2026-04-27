package com.starl0stgaming.pyxisapi.core;

import com.starl0stgaming.pyxisapi.PyxisAPI;
import com.starl0stgaming.pyxisapi.data.node.PyxisNodeRegistry;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

@EventBusSubscriber(modid = PyxisAPI.MODID)
public class CommonEvents {

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public static void onLevelLoad(LevelEvent.Load event) {
        PyxisNodeRegistry.onLevelLoad(event);
    }

    @SubscribeEvent
    public static void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        /*
        event.dataPackRegistry(
                PyxisAPI.PYXISNODE_REGISTRY_KEY,
                PyxisNode.CODEC,
                PyxisNode.CODEC, //network codec
                builder -> builder.maxId(256)
        );
        event.dataPackRegistry(
                PyxisAPI.PYXISTYPE_REGISTRY_KEY,
                PyxisType.CODEC,
                PyxisType.CODEC,
                builder -> builder.maxId(256)
        );
         */
    }

    @SubscribeEvent
    public static void registerReloadListener(AddServerReloadListenersEvent event) {
        event.addListener(Identifier.fromNamespaceAndPath(
                PyxisAPI.MODID, "pyxis_type_loader"
        ), PyxisAPI.pyxisTypeLoader);
        event.addListener(Identifier.fromNamespaceAndPath(
                PyxisAPI.MODID, "pyxis_node_loader"
        ), PyxisAPI.pyxisNodeLoader);
        PyxisAPI.LOGGER.info("Pyxis Node & Type loaders have been registered");
    }
}
