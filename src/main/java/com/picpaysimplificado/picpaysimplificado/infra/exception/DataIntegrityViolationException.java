package com.picpaysimplificado.picpaysimplificado.infra.exception;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String message) {
        super(message);
    }

}
