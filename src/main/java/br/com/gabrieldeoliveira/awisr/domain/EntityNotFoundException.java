package br.com.gabrieldeoliveira.awisr.domain;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
