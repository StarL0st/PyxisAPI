package com.starl0stgaming.pyxisapi.data.handle;

import com.starl0stgaming.pyxisapi.data.node.interaction.PyxisNodeHitbox;
import com.starl0stgaming.pyxisapi.data.node.state.PyxisNodeStateRender.PyxisStateRenderInfo;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.Map;

public class PyxisNodeDefinition {
    //meta
    private final Identifier node;
    private final Identifier type;
    private final Map<String, PyxisStateRenderInfo> states;
    private final List<PyxisNodeHitbox> hitboxes;

    public PyxisNodeDefinition(Identifier node, Identifier type, Map<String, PyxisStateRenderInfo> states, List<PyxisNodeHitbox> hitboxes) {
        this.node = node;
        this.type = type;
        this.states = states;
        this.hitboxes = hitboxes;
    }

    public Identifier getNode() {
        return node;
    }

    public PyxisStateRenderInfo getState(String state) {
        return this.states.get(state);
    }

    public Identifier getType() {
        return type;
    }

    public Map<String, PyxisStateRenderInfo> getStates() {
        return states;
    }

    public List<PyxisNodeHitbox> getHitboxes() {
        return hitboxes;
    }
}
