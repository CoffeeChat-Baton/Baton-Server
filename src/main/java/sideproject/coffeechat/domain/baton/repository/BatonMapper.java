package sideproject.coffeechat.domain.baton.repository;

import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BatonMapper {

    Map<String, Long> getBatonStatusCounts(Long mentorId);

}
