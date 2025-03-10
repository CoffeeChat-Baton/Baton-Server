package sideproject.coffeechat.domain.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerJoinRequest {

    @NotNull
    private String nickname;

    @NotNull
    private Long jobId;

    // Job 이 "기타"인 경우만 필요
    private String customJobName;

    @NotNull
    private Long subJobId;

    // SubJob 이 "기타"인 경우만 필요
    private String customSubJobName;

    @NotNull
    private Integer careerYears;

    @Email
    private String email;

}
