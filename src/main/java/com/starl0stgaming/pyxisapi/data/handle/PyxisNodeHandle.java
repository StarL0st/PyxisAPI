package com.starl0stgaming.pyxisapi.data.handle;

import com.starl0stgaming.pyxisapi.data.node.interaction.PyxisNodeHitbox;
import com.starl0stgaming.pyxisapi.data.node.state.PyxisNodeStateRender.PyxisStateRenderInfo;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;

public class PyxisNodeHandle {
    //meta
    private final ResourceLocation node;
    private final ResourceLocation type;
    private final Map<String, PyxisStateRenderInfo> states;
    private final List<PyxisNodeHitbox> hitboxes;

    public PyxisNodeHandle(ResourceLocation node, ResourceLocation type, Map<String, PyxisStateRenderInfo> states, List<PyxisNodeHitbox> hitboxes) {
        this.node = node;
        this.type = type;
        this.states = states;
        this.hitboxes = hitboxes;
    }

    public ResourceLocation getNode() {
        return node;
    }

    public PyxisStateRenderInfo getState(String state) {
        return this.states.get(state);
    }

    public ResourceLocation getType() {
        return type;
    }

    public Map<String, PyxisStateRenderInfo> getStates() {
        return states;
    }

    public List<PyxisNodeHitbox> getHitboxes() {
        return hitboxes;
    }
}
