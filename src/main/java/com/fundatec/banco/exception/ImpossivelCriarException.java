package com.fundatec.banco.exception;

public class ImpossivelCriarException extends RuntimeException {

    public ImpossivelCriarException(String message) {
        super("impossivel criar " + message +" por motivos de sintaxe");
    }

    public ImpossivelCriarException(String message, Throwable cause) {
        super(message, cause);
    }
}