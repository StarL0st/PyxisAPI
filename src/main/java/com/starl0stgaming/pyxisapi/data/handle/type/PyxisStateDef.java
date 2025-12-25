package com.starl0stgaming.pyxisapi.data.handle.type;

public sealed interface PyxisStateDef permits EnumStateDef, BoolStateDef, IntStateDef, FloatStateDef {
    String name();
    Object defaultValue();
    boolean isValid(Object value);
}
