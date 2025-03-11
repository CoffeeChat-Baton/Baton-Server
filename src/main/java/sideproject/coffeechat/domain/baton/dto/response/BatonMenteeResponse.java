package sideproject.coffeechat.domain.baton.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sideproject.coffeechat.domain.member.entity.MemberType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatonMenteeResponse {

    private MemberType memberType;

    private String profileImageUrl;

    private String nickname;

    private String division;

    private String section;

    private Integer careerYears;

}
