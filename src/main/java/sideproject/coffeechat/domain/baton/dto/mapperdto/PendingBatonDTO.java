package sideproject.coffeechat.domain.baton.dto.mapperdto;

import java.time.LocalDateTime;
import lombok.Getter;
import sideproject.coffeechat.domain.baton.entity.BatonType;
import sideproject.coffeechat.domain.member.entity.MemberType;

@Getter
public class PendingBatonDTO {

    private Long batonId;

    private BatonType batonType;

    private String chatBatonDuration;

    private MemberType memberType;

    private String profileImageUrl;

    private String nickname;

    private String educationName; // for STUDENT

    private String majorName; // for STUDENT

    private String jobName; // for WORKER

    private String subJobName; // for WORKER

    private Integer careerYears; // for WORKER

    private LocalDateTime createdAt;

}
