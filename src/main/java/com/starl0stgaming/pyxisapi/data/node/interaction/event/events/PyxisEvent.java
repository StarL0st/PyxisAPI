package com.starl0stgaming.pyxisapi.data.node.interaction.event.events;

import com.starl0stgaming.pyxisapi.data.node.PyxisNodeInstance;

public interface PyxisEvent {
    PyxisEventType type();
    PyxisNodeInstance node();
}
