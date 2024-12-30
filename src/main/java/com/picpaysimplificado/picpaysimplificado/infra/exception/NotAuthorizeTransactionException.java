package com.picpaysimplificado.picpaysimplificado.infra.exception;

public class NotAuthorizeTransactionException extends RuntimeException{
    public NotAuthorizeTransactionException(String message){
        super (message);
    }
}
