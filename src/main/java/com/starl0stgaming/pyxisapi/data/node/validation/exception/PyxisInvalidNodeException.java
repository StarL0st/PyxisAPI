package com.starl0stgaming.pyxisapi.data.node.validation.exception;

public class PyxisInvalidNodeException extends RuntimeException {
    public PyxisInvalidNodeException(String msg) {
        super(msg);
    }

    public PyxisInvalidNodeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
