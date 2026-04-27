package com.starl0stgaming.pyxisapi.data.node.interaction.event.bus;

import com.starl0stgaming.pyxisapi.data.node.interaction.event.events.PyxisEvent;
import com.starl0stgaming.pyxisapi.data.node.interaction.event.events.PyxisEventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class PyxisEventBus {
    private static final Map<PyxisEventType, List<Consumer<PyxisEvent>>> listeners = new HashMap<>();

    public static void register(PyxisEventType type, Consumer<PyxisEvent> listener) {
        listeners.computeIfAbsent(type, t -> new ArrayList<>()).add(listener);
    }

    public static void emit(PyxisEvent event) {
        List<Consumer<PyxisEvent>> list = listeners.get(event.type());
        if(list != null) {
            list.forEach(consumer -> consumer.accept(event));
        }
    }
}
