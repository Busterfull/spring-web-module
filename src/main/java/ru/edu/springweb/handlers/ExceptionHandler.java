package ru.edu.springweb.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import ru.edu.springweb.exception.LibraryException;
import ru.edu.springweb.http.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(LibraryException.class)
    public ResponseEntity<ExceptionResponse> handlerLibraryException(LibraryException e) {
        var response = new ExceptionResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
