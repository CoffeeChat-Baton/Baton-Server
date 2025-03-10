package sideproject.coffeechat.domain.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentJoinRequest {

    @NotNull
    private String nickname;

    @NotNull
    private Long educationId;

    // Education 이 "기타"인 경우만 필요
    private String customEducationName;

    @NotNull
    private Long majorId;

    // Major 이 "기타"인 경우만 필요
    private String customMajorName;

    @NotNull
    private Boolean isEnrolled;

    @Email
    private String email;

}
