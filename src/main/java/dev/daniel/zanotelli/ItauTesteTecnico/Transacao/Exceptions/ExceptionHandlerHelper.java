package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerHelper {

    @ExceptionHandler(UnprocessableEntity.class)
    public ResponseEntity<ErrorResponse> handleUnprocessableEntity(UnprocessableEntity ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.UNPROCESSABLE_CONTENT.value());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
