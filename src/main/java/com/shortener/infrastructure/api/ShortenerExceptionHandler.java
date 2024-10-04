package com.shortener.infrastructure.api;

import com.shortener.domain.HashAlreadyInUse;
import com.shortener.domain.RedirectNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShortenerExceptionHandler {

    @ExceptionHandler(HashAlreadyInUse.class)
    public ResponseEntity<String> handleHashAlreadyInUse(HashAlreadyInUse ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(RedirectNotFound.class)
    public ResponseEntity<String> handleRedirectNotFound(RedirectNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error");
    }
}
