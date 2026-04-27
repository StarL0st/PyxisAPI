package com.starl0stgaming.pyxisapi.data.node.behavior.action;

@FunctionalInterface
public interface PyxisActionHandler {
    void run(PyxisExternalActionContext ctx);
}
