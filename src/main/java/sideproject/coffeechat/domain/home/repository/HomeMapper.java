package sideproject.coffeechat.domain.home.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import sideproject.coffeechat.domain.home.dto.JobWithMinSubJobDTO;

@Mapper
public interface HomeMapper {

    List<JobWithMinSubJobDTO> findAllJobsWithMinSubJob();

}
