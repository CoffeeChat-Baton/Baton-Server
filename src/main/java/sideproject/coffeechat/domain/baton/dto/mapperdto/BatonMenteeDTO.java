package sideproject.coffeechat.domain.baton.dto.mapperdto;

import lombok.Getter;
import sideproject.coffeechat.domain.member.entity.MemberType;

@Getter
public class BatonMenteeDTO {

    private MemberType memberType;

    private String profileImageUrl;

    private String nickname;

    private String educationName; // for STUDENT

    private String majorName; // for STUDENT

    private String jobName; // for WORKER

    private String subJobName; // for WORKER

    private Integer careerYears; // for WORKER

}
