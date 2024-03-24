package br.com.gabrieldeoliveira.awisr.api.exceptions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ValidationError extends AbstractError {

    private Set<FieldMessage> errors = new HashSet<FieldMessage>();

    public ValidationError(Instant timestamp, Integer status, String title, String path) {
        super(timestamp, status, title, path);
    }

    public void addError(FieldMessage error) {
        errors.add(error);
    };

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FieldMessage {
        private String field;
        private String message;
    }
}
