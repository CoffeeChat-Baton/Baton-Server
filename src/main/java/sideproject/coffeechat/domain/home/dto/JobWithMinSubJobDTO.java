package sideproject.coffeechat.domain.home.dto;

import lombok.Getter;

@Getter
public class JobWithMinSubJobDTO {

    private Long jobId;

    private String jobName;

    private Long minSubJobId;

    private String minSubJobName;

}
