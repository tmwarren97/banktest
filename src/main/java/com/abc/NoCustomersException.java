package com.abc;

public class NoCustomersException extends RuntimeException {
    public NoCustomersException() {
    }

    public NoCustomersException(String message) {
        super(message);
    }
}
