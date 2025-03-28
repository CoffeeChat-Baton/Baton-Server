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
    WORKER_REQUEST_ERROR(HttpStatus.BAD_REQUEST, "Bad Worker Request"),
    EDUCATION_NOT_FOUND(HttpStatus.BAD_REQUEST, "Education not found."),
    STUDENT_REQUEST_ERROR(HttpStatus.BAD_REQUEST, "Bad Student Request"),

    // MentorException
    MENTOR_NOT_FOUND(HttpStatus.NOT_FOUND, "Mentor not found."),

    // BatonException
    BATON_NOT_FOUND(HttpStatus.NOT_FOUND, "Baton not found."),

    //CustomException
    S3_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S3 error."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
