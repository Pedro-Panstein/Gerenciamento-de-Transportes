package com.weg.Gerenciamento_de_Transportes.controller.exception;

import com.weg.Gerenciamento_de_Transportes.model.dtos.ErrorDtO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDtO> handleRuntimeException(RuntimeException exception) {
        ErrorDtO error = new ErrorDtO(exception.getMessage(), Instant.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDtO> handleIllegalArgumentException(IllegalArgumentException exception) {
        ErrorDtO error = new ErrorDtO(exception.getMessage(), Instant.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDtO> handleNoSuchElementException(NoSuchElementException exception) {
        ErrorDtO error = new ErrorDtO(exception.getMessage(), Instant.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
