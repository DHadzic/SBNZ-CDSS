package com.siit.sbnz.security;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException() { }

    public ForbiddenException(String message) {
        super(message);
    }
}