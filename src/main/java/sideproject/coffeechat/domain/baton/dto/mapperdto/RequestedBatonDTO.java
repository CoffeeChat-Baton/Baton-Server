package sideproject.coffeechat.domain.baton.dto.mapperdto;

import lombok.Getter;
import sideproject.coffeechat.domain.baton.entity.BatonType;

@Getter
public class RequestedBatonDTO {

    private BatonType batonType;

    private String chatBatonDuration;

    private String profileImageUrl;

    private String nickname;

    private String companyName;

    private String jobName;

    private String subJobName;

    private Integer careerYears;

}
