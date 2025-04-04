package sideproject.coffeechat.domain.baton.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sideproject.coffeechat.domain.baton.entity.BatonType;
import sideproject.coffeechat.domain.member.entity.MemberType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompactBatonResponse {

    private Long batonId;

    private BatonType batonType;

    // BatonType == CHAT 인 경우만 필요
    private String chatBatonDuration;

    private MemberType memberType;

    private String profileImageUrl;

    private String nickname;

    // 멘토 바통 경우만 필요
    private String companyName;

    // 학생 → 학력 | 직장인 → 직무
    private String division;

    // 학생 → 전공 | 직장인 → 세부 직무
    private String section;

    // 직장인 & 멘토 경우만 필요
    private Integer careerYears;

    private Long dueInDays;

}
