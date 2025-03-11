package sideproject.coffeechat.domain.baton.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingChatBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedChatBatonDTO;
import sideproject.coffeechat.domain.baton.entity.BatonType;

@Mapper
public interface BatonMapper {

    List<RequestedBatonDTO> getRequestedBatons(String menteeUsername, BatonType batonType, int size, int offset);

    List<PendingBatonDTO> getPendingBatons(String mentorUsername, BatonType batonType, int size, int offset);

    RequestedChatBatonDTO getRequestedChatBaton(Long batonId);

    PendingChatBatonDTO getPendingChatBaton(Long batonId);

}
