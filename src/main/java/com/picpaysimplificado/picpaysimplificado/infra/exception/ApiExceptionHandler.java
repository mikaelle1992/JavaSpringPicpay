package com.picpaysimplificado.picpaysimplificado.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorMessage> handleInsufficientBalanceException(InsufficientBalanceException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(UnauthorizedTransactionException.class)
    public ResponseEntity<ErrorMessage> handleUnauthorizedTransactionException(UnauthorizedTransactionException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorMessage(request, HttpStatus.UNAUTHORIZED, ex.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }


    @ExceptionHandler(NotAuthorizeTransactionException.class)
    public ResponseEntity<ErrorMessage> handleNotAuthorizeTransactionException(NotAuthorizeTransactionException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }


}
