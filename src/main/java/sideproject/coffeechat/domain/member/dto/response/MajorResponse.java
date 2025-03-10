package sideproject.coffeechat.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MajorResponse {

    private Long educationId;

    private Long majorId;

    private String majorName;

}
