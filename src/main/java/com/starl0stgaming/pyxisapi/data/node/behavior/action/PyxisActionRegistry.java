package com.starl0stgaming.pyxisapi.data.node.behavior.action;

import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PyxisActionRegistry {
    private static final HashMap<Identifier, List<PyxisActionHandler>> EVENTS = new HashMap<>();

    public static void register(Identifier id, PyxisActionHandler handler) {
        EVENTS.computeIfAbsent(id, k -> new ArrayList<>()).add(handler);
    }

    public static void fire(Identifier id, PyxisExternalActionContext ctx) {
        List<PyxisActionHandler> handlers = EVENTS.get(id);
        if(handlers != null) {
            handlers.forEach(h -> h.run(ctx));
        }

    }
}
