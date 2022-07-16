package com.fundatec.banco.exception;

public class ImpossivelCriarException extends RuntimeException {

    public ImpossivelCriarException(String message) {
        super("impossivel criar tal objeto, reveja a maneira com a qual passou os dados" + message);
    }

    public ImpossivelCriarException(String message, Throwable cause) {
        super(message, cause);
    }
}