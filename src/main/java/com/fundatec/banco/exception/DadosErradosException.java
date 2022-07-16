package com.fundatec.banco.exception;

public class DadosErradosException extends RuntimeException {

    public DadosErradosException(String message) {
        super("INFORMAÇÕES ERRADOAS, POR FAVOR REVEJA ELAS E TENTE NOVAMENTE" + message);
    }

    public DadosErradosException(String message, Throwable cause) {
        super(message, cause);
    }
}