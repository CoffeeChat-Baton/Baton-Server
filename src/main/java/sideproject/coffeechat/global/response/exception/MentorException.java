package sideproject.coffeechat.global.response.exception;

import sideproject.coffeechat.global.response.code.ErrorCode;

public class MentorException extends CustomException {

    public MentorException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public MentorException(ErrorCode errorCode) {
        super(errorCode);
    }

}
