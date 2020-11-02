package com.github.lbovolini.elofy.exception;

public class NameAlreadyRegisteredException extends RuntimeException {

    private static final String message = "Name already registered";

    public NameAlreadyRegisteredException() {
        super(message);
    }
}
