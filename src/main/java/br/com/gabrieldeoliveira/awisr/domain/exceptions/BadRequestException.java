package br.com.gabrieldeoliveira.awisr.domain.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
