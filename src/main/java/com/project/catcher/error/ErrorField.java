package com.project.catcher.error;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.Objects;

@Getter
public class ErrorField {

    private final String field;
    private final String value;
    private final String reason;

    private ErrorField(FieldError fieldError) {
        this.field = fieldError.getField();
        this.value = Objects.requireNonNull(fieldError.getRejectedValue()).toString();
        this.reason = fieldError.getDefaultMessage();
    }

    public static ErrorField from(FieldError fieldError) {
        return new ErrorField(fieldError);
    }
}
