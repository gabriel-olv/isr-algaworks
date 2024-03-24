package br.com.gabrieldeoliveira.awisr.api.exceptions.handler;

import br.com.gabrieldeoliveira.awisr.api.exceptions.models.StandardError;
import br.com.gabrieldeoliveira.awisr.api.exceptions.models.ValidationError;
import br.com.gabrieldeoliveira.awisr.domain.exceptions.BadRequestException;
import br.com.gabrieldeoliveira.awisr.domain.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    private MessageSource messageSource;

    @ExceptionHandler({ BadRequestException.class, HttpMessageNotReadableException.class })
    ResponseEntity<StandardError> badRequestException(Exception ex, HttpServletRequest request) {
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
    ResponseEntity<StandardError> notFoundException(EntityNotFoundException ex, HttpServletRequest request) {
        int status = HttpStatus.NOT_FOUND.value();
        StandardError error = new StandardError(
                Instant.now(),
                status,
                "Not Found",
                request.getRequestURI(),
                ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ValidationError> badRequestException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        int status = HttpStatus.BAD_REQUEST.value();
        ValidationError error = new ValidationError(
                Instant.now(),
                status,
                "Validation Error",
                request.getRequestURI());

        ex.getFieldErrors().stream()
                .map(fieldError -> {
                    final ValidationError.FieldMessage fieldMessage = new ValidationError.FieldMessage();
                    fieldMessage.setField(fieldError.getField());
                    fieldMessage.setMessage(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()));
                    return fieldMessage;
                }).forEach(error::addError);

        return ResponseEntity.status(status).body(error);
    }
}
