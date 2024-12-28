package com.picpaysimplificado.picpaysimplificado.infra.exception;

public class InsufficientBalanceException extends RuntimeException{
    
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
