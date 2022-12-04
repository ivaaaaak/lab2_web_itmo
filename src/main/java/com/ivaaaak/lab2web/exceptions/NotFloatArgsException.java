package com.ivaaaak.lab2web.exceptions;

public class NotFloatArgsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "All parameters must be numbers";
    }
}
