package com.fundatec.banco.exception;

public class ObjetoNaoEncontradoException extends RuntimeException {

    public ObjetoNaoEncontradoException(String message) {
        super("objeto não encontrado, favor rever as informações e tentar novamente" + message);
    }

    public ObjetoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
