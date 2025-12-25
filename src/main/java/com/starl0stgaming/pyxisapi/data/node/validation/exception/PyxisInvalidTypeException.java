package com.starl0stgaming.pyxisapi.data.node.validation.exception;

public class PyxisInvalidTypeException extends RuntimeException {
    public PyxisInvalidTypeException(String msg) {
        super(msg);
    }

    public PyxisInvalidTypeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
