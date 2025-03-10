package sideproject.coffeechat.domain.baton.dto.mapperdto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PendingBatonDTO {

    private String batonType;

    private String chatBatonDuration;

    private String memberType;

    private String profileImageUrl;

    private String nickname;

    private String educationName; // for STUDENT

    private String majorName; // for STUDENT

    private String jobName; // for WORKER

    private String subJobName; // for WORKER

    private Integer careerYears; // for WORKER

    private LocalDateTime createdAt;

}
