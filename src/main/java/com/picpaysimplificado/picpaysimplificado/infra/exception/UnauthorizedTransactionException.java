package com.picpaysimplificado.picpaysimplificado.infra.exception;

public class UnauthorizedTransactionException extends RuntimeException {

    public UnauthorizedTransactionException(String message) {
        super(message);
    }
}
