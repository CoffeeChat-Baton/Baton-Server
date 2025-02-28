package sideproject.coffeechat.global.response.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sideproject.coffeechat.global.response.code.ErrorCode;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private ErrorCode errorCode;
    private String message;

    public CustomException(ErrorCode errorCode) {
      this.errorCode = errorCode;
      this.message = errorCode.getMessage();
    }

}
