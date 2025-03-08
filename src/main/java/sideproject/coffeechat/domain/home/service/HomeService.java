package sideproject.coffeechat.domain.home.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.coffeechat.domain.home.dto.HomeConverter;
import sideproject.coffeechat.domain.home.dto.HomeJobResponse;
import sideproject.coffeechat.domain.home.dto.JobWithMinSubJobDTO;
import sideproject.coffeechat.domain.home.repository.HomeMapper;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeService {

    private final HomeMapper homeMapper;

    public List<HomeJobResponse> getJobs() {
        List<JobWithMinSubJobDTO> jobWithMinSubJobDTOS = homeMapper.findAllJobsWithMinSubJob();
        return HomeConverter.toHomeJobResponses(jobWithMinSubJobDTOS);
    }

}
