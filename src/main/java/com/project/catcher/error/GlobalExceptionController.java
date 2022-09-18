package com.project.catcher.error;

import com.project.catcher.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.catcher.error.ErrorCode.REQUIRED_REQUSET_BODY;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = { HttpMessageNotReadableException.class })
    protected ResponseEntity<ErrorDto> handleCustomException() {
        log.error("handleCustomException throw CustomException : {}", REQUIRED_REQUSET_BODY.getMessage());
        return ResponseEntity.badRequest().body(ErrorDto.of(REQUIRED_REQUSET_BODY.getHttpStatus().value(), REQUIRED_REQUSET_BODY.getMessage()));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDto> businessError(BusinessException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        ErrorDto response = ErrorDto
                .of(errorCode.getHttpStatus().value(), errorCode.getMessage());
        log.error("Business Exception : {}", response);
        return ResponseEntity.status(errorCode.getHttpStatus()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> dataValidateError(MethodArgumentNotValidException e) {
        ErrorDto response = ErrorDto.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message("입력값이 올바르지 않습니다.")
                .errors(createMessage(e))
                .build();
        log.error("Validate Exception : {}",response);
        return ResponseEntity.badRequest().body(response);
    }

    private List<ErrorField> createMessage(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        return fieldErrors.stream().map(ErrorField::from).collect(Collectors.toList());
    }

}
