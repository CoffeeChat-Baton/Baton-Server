package sideproject.coffeechat.domain.mentor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompactMentorResponse {

    private Long mentorId;

    private String profileImageUrl;

    private String nickname;

    private String companyName;

    private String jobName;

    private String subJobName;

    private int careerYears;

    private String shortDescription;

    private Long mentoringCount;

    private Double responseRate;

    private boolean isBookmarked;

}
