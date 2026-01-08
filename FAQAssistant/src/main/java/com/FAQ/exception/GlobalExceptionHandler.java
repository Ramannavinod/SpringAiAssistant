package com.FAQ.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequest(
            InvalidRequestException ex) {

        ErrorResponse er =
                new ErrorResponse(ex.getMessage(),
                        HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex) {

        ErrorResponse er =
                new ErrorResponse("Internal server error",
                        HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
