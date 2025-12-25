package com.starl0stgaming.pyxisapi.data.handle.type;

import java.util.List;
import java.util.Set;

public final class EnumStateDef implements PyxisStateDef {
    private final String name;
    private final List<String> values;
    private final String defaultValue;

    public EnumStateDef(String name, List<String> values, String defaultValue) {
        this.name = name;
        this.values = values;
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

    public List<String> getValues() {
        return values;
    }

    @Override
    public boolean isValid(Object value) {
        return value instanceof String s && values.contains(s);
    }
}
