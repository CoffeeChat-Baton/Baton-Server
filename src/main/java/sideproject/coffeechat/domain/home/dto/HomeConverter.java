package sideproject.coffeechat.domain.home.dto;

import java.util.List;

public class HomeConverter {

    public static List<HomeJobResponse> toHomeJobResponses(List<JobWithMinSubJobDTO> dtos) {
        return dtos.stream()
                .map(dto -> {
                    return HomeJobResponse.builder()
                            .jobId(dto.getJobId())
                            .jobName(dto.getJobName())
                            .defaultSubJobId(dto.getMinSubJobId())
                            .defaultSubJobName(dto.getMinSubJobName())
                            .build();
                }).toList();
    }

}
