package com.fundatec.banco.exception;

public class ObjetoNaoEncontradoException extends RuntimeException {

    public ObjetoNaoEncontradoException(String message) {
        super("não foi possivel encontrar "  + message);
    }

    public ObjetoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
