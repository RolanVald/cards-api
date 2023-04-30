package com.cards.api.controllers;

import com.cards.api.exception.custom.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cards.api.exception.ExceptionResponse;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> illegalArgumentException(IllegalArgumentException iae) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), iae.getMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> runtimeException(RuntimeException re) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), re.getMessage());
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionResponse> indexOutOfBoundsException(IndexOutOfBoundsException iob) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), iob.getMessage());
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResponse> nullPointerException(NullPointerException npe) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), npe.getMessage());
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException umt) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), umt.getMessage());
        return new ResponseEntity<>(er, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exception(Exception e) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ExceptionResponse> httpMessageConversionException(HttpMessageConversionException e) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponse> cardNotFoundException(EntityNotFoundException e) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }
}
