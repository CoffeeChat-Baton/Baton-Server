package sideproject.coffeechat.domain.baton.dto.mapperdto;

import lombok.Getter;

@Getter
public class RequestedBatonDTO {

    private String batonType;

    private String chatBatonDuration;

    private String profileImageUrl;

    private String nickname;

    private String companyName;

    private String jobName;

    private String subJobName;

    private int careerYears;

}
