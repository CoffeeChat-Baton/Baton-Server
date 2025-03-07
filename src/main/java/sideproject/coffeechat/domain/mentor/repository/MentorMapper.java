package sideproject.coffeechat.domain.mentor.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import sideproject.coffeechat.domain.mentor.dto.CompactMentorDTO;

@Mapper
public interface MentorMapper {

    List<CompactMentorDTO> findMentorsByJobId(
            Long jobId, Long subJobId, Long memberId, int size, int offset, String sortBy
    );

}
