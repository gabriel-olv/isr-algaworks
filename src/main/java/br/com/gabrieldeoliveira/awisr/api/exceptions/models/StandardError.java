package br.com.gabrieldeoliveira.awisr.api.exceptions.models;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
public class StandardError extends AbstractError {

    private String message;

    public StandardError(Instant timestamp, Integer status, String title, String path, String message) {
        super(timestamp, status, title, path);
        this.message = message;
    }
}
