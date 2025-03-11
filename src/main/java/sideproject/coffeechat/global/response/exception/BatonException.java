package sideproject.coffeechat.global.response.exception;

import sideproject.coffeechat.global.response.code.ErrorCode;

public class BatonException extends CustomException {

    public BatonException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public BatonException(ErrorCode errorCode) {
        super(errorCode);
    }

}
