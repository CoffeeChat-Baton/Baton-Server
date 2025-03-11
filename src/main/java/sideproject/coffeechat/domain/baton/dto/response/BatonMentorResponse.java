package sideproject.coffeechat.domain.baton.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatonMentorResponse {

    private String profileImageUrl;

    private String nickname;

    private String companyName;

    private String jobName;

    private String subJobName;

    private Integer careerYears;

    private String shortDescription;

}
