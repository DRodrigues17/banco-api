package com.fundatec.banco.exception;

public class ConflitoException extends RuntimeException {

    public ConflitoException(String message) {
        super("impossivel criar, pois tal "+message+" entra em conflito com um já existente," +
                "reveja as informações");
    }

    public ConflitoException(String message, Throwable cause) {
        super(message, cause);
    }
}