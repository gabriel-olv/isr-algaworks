package br.com.gabrieldeoliveira.awisr.api.exceptions.handler;

import br.com.gabrieldeoliveira.awisr.api.exceptions.models.StandardError;
import br.com.gabrieldeoliveira.awisr.domain.exceptions.BadRequestException;
import br.com.gabrieldeoliveira.awisr.domain.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<StandardError> badRequestException(BadRequestException ex, HttpServletRequest request) {
        int status = HttpStatus.BAD_REQUEST.value();
        StandardError error = new StandardError(
                Instant.now(),
                status,
                "Bad Request",
                request.getRequestURI(),
                ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<StandardError> badRequestException(EntityNotFoundException ex, HttpServletRequest request) {
        int status = HttpStatus.NOT_FOUND.value();
        StandardError error = new StandardError(
                Instant.now(),
                status,
                "Not Found",
                request.getRequestURI(),
                ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }
}
