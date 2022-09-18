package com.project.catcher.error;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ErrorDto {

    private final int statusCode;
    private final String message;
    private List<ErrorField> errors;
    private final LocalDateTime timestamp = LocalDateTime.now();

    private ErrorDto(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    @Builder
    public ErrorDto(int statusCode, String message,
                         List<ErrorField> errors) {
        this.statusCode = statusCode;
        this.message = message;
        this.errors = errors;
    }

    public static ErrorDto from(ErrorCode errorCode){
        return new ErrorDto(errorCode.getHttpStatus().value(), errorCode.getMessage());
    }
    public static ErrorDto of(int statusCode, String message) {
        return new ErrorDto(statusCode, message);
    }
}