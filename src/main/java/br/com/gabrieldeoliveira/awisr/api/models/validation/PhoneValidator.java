package br.com.gabrieldeoliveira.awisr.api.models.validation;

import jakarta.validation.*;
import jakarta.validation.metadata.ConstraintDescriptor;

import java.util.Set;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("\\d{11}");
    }
}
