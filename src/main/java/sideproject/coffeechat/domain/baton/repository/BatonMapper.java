package sideproject.coffeechat.domain.baton.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedBatonDTO;
import sideproject.coffeechat.domain.baton.entity.BatonType;

@Mapper
public interface BatonMapper {

    List<RequestedBatonDTO> getRequestedBatons(Long menteeId, BatonType batonType, int size, int offset);

    List<PendingBatonDTO> getPendingBatons(Long mentorId, BatonType batonType, int size, int offset);

}
