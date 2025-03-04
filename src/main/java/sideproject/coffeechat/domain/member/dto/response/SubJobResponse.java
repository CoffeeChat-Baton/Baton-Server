package sideproject.coffeechat.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubJobResponse {

    private Long jobId;

    private Long subJobId;

    private String subJobName;

}
