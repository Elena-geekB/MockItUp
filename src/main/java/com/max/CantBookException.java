package com.max;

public class CantBookException extends Exception {
    public CantBookException() {
        super("Cannot book the requested slot.");
    }
}
