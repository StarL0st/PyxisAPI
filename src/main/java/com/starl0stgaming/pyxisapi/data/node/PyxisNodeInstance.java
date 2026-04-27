package com.starl0stgaming.pyxisapi.data.node;

import com.starl0stgaming.pyxisapi.data.handle.PyxisNodeDefinition;
import com.starl0stgaming.pyxisapi.data.node.interaction.event.bus.PyxisEventBus;
import com.starl0stgaming.pyxisapi.data.node.interaction.event.events.PyxisStateChangedEvent;

import java.util.Map;
import java.util.UUID;

public class PyxisNodeInstance {
    private final UUID id;
    private final PyxisNodeDefinition def;
    private final Map<String, Object> state;

    public PyxisNodeInstance(UUID id, PyxisNodeDefinition def, Map<String, Object> state) {
        this.id = id;
        this.def = def;
        this.state = state;
    }

    public void setState(String stateId, Object value) {
        Object old = this.state.put(stateId, value);
        PyxisEventBus.emit(new PyxisStateChangedEvent(this, stateId, old, value));
    }
}
