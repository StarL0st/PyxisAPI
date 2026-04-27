package com.starl0stgaming.pyxisapi.data.handle;

import com.starl0stgaming.pyxisapi.data.handle.type.PyxisStateDef;
import com.starl0stgaming.pyxisapi.data.node.interaction.PyxisInteractionType;
import net.minecraft.resources.Identifier;

import java.util.Map;
import java.util.Set;

public class PyxisTypeHandle {
    private final Identifier type;
    private final Set<PyxisInteractionType> interactions;
    private final Map<String, PyxisStateDef> states;

    public PyxisTypeHandle(Identifier type, Set<PyxisInteractionType> interactions, Map<String, PyxisStateDef> states) {
        this.type = type;
        this.interactions = interactions;
        this.states = states;
    }

    public Identifier getType() {
        return type;
    }

    public Set<PyxisInteractionType> getInteractions() {
        return interactions;
    }

    public Map<String, PyxisStateDef> getStates() {
        return states;
    }

    public PyxisStateDef getState(String id) {
        return this.states.get(id);
    }
}
