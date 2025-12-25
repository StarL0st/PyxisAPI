package com.starl0stgaming.pyxisapi;

import com.mojang.logging.LogUtils;
import com.starl0stgaming.pyxisapi.data.node.PyxisNodeRegistry;
import com.starl0stgaming.pyxisapi.data.node.loader.PyxisNodeLoader;
import com.starl0stgaming.pyxisapi.data.node.loader.PyxisTypeLoader;
import com.starl0stgaming.pyxisapi.data.node.type.PyxisTypeRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;


@Mod(PyxisAPI.MODID)
public class PyxisAPI {
    public static PyxisNodeLoader pyxisNodeLoader = new PyxisNodeLoader();
    public static PyxisTypeLoader pyxisTypeLoader = new PyxisTypeLoader();

    public static final PyxisNodeRegistry NODE_REGISTRY = new PyxisNodeRegistry();
    public static final PyxisTypeRegistry TYPE_REGISTRY = new PyxisTypeRegistry();

    public static final String MODID = "pyxisapi";

    public static final Logger LOGGER = LogUtils.getLogger();

    public PyxisAPI(IEventBus modEventBus, ModContainer modContainer) {

    }



}
