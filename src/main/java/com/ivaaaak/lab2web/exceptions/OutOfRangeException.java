package com.ivaaaak.lab2web.exceptions;

public class OutOfRangeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "R must be greater than 0, -5 <= (X, Y) <= 3";
    }
}
