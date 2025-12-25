package com.starl0stgaming.pyxisapi.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static com.starl0stgaming.pyxisapi.PyxisAPI.MODID;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

    }
}
