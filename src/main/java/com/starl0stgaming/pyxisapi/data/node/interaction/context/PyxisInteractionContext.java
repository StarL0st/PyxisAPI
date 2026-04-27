package com.starl0stgaming.pyxisapi.data.node.interaction.context;

import net.minecraft.resources.Identifier;

public class PyxisInteractionContext {
    private final Identifier id;

    public PyxisInteractionContext(Identifier id) {
        this.id = id;
    }

    public Identifier getId() {
        return id;
    }
}
