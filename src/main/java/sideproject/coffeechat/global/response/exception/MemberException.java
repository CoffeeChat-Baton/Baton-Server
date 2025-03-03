package sideproject.coffeechat.global.response.exception;

import sideproject.coffeechat.global.response.code.ErrorCode;

public class MemberException extends CustomException {

    public MemberException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }

}
