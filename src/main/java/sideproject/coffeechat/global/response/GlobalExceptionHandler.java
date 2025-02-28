package sideproject.coffeechat.global.response;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.LinkedHashMap;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sideproject.coffeechat.global.response.code.ErrorCode;
import sideproject.coffeechat.global.response.exception.CustomException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // @Valid RequestBody, @Validated RequestParam 예외 핸들링
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        LinkedHashMap<String, String> errors = new LinkedHashMap<>();

        e.getBindingResult().getFieldErrors()
                .forEach(fieldError -> {
                    String fieldName = fieldError.getField();
                    String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
                    errors.merge(fieldName, errorMessage,
                            (existingErrorMessage, newErrorMessage) -> existingErrorMessage + ", " + newErrorMessage);
                });

        return ResponseEntity.status(BAD_REQUEST)
                .body(Response.error("Request is incomplete.", errors));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException e) {
        log.error("Error occurs : {}", e.toString());
        ErrorCode errorCode = e.getErrorCode();
        String message = e.getMessage();
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(Response.error(message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        log.error("어플리케이션 실행 중 에러 발생 {}", e.getMessage(), e);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(Response.error(e.getMessage()));
    }

}
