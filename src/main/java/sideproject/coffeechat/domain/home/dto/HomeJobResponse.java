package sideproject.coffeechat.domain.home.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HomeJobResponse {

    private Long jobId;

    private String jobName;

    private Long defaultSubJobId;

    private String defaultSubJobName;

}
