package com.starl0stgaming.pyxisapi.data.handle.type;

public final class BoolStateDef implements PyxisStateDef {
    private final String name;
    private final boolean defaultValue;

    public BoolStateDef(String name, boolean defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Object defaultValue() {
        return defaultValue;
    }

    @Override
    public boolean isValid(Object value) {
        return value instanceof Boolean;
    }
}
