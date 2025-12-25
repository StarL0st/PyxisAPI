package com.starl0stgaming.pyxisapi.data.handle.type;

public final class IntStateDef implements PyxisStateDef {
    private final String name;
    private final int defaultValue;

    public IntStateDef(String name, int defaultValue) {
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
        return value instanceof Integer;
    }
}
