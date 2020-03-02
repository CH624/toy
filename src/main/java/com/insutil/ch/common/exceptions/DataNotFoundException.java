package com.insutil.ch.common.exceptions;

public class DataNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public DataNotFoundException() {
        super("Data was not founded...");
    }

    public DataNotFoundException(final String msg) {
        super(msg);
    }

    public DataNotFoundException(final String msg, Throwable t) {
        super(msg, t);
    }
}
