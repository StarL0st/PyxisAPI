package com.starl0stgaming.pyxisapi.data.node.validation.exception;

public class PyxisInvalidStateException extends RuntimeException {
    public PyxisInvalidStateException(String msg) {
        super(msg);
    }

    public PyxisInvalidStateException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
