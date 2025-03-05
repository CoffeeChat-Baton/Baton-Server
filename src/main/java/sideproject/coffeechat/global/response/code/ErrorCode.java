package sideproject.coffeechat.global.response.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // MemberException
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "Member not found."),
    WORKER_NOT_FOUND(HttpStatus.NOT_FOUND, "Worker not found."),
    MEMBER_TYPE_ERROR(HttpStatus.BAD_REQUEST, "Member type error."),
    SOCIAL_TYPE_ERROR(HttpStatus.BAD_REQUEST, "Social type request error."),
    JOB_NOT_FOUND(HttpStatus.BAD_REQUEST, "Job not found."),
    SUB_JOB_NOT_FOUND(HttpStatus.BAD_REQUEST, "SubJob not found."),
    JOB_REQUEST_ERROR(HttpStatus.BAD_REQUEST, "Job error."),

    // MentorException
    MENTOR_NOT_FOUND(HttpStatus.NOT_FOUND, "Mentor not found."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
