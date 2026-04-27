package com.starl0stgaming.pyxisapi.data.node.interaction.event.events;

import com.starl0stgaming.pyxisapi.data.node.PyxisNodeInstance;

public record PyxisStateChangedEvent(
        PyxisNodeInstance node,
        String stateId,
        Object oldValue,
        Object newValue
) implements PyxisEvent {
    @Override
    public PyxisEventType type() {
        return PyxisEventType.STATE_CHANGED;
    }
}
