package com.prodigio.products.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandled(Exception ex) {
        logger.error("Exception { catalogs microservice } with details :::: " + ex.getMessage());
        return new ResponseEntity<>(
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GlobalCustomException.class)
    public ResponseEntity<String> globalExceptionHandled(GlobalCustomException global) {
        logger.error("Exception { Workflow microservice } with details :::: " + global.getMessage());
        return new ResponseEntity<>(
                global.getMessage(),
                global.getStatus());
    }
}
