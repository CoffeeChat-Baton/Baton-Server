package sideproject.coffeechat.domain.baton.service;

import static sideproject.coffeechat.global.response.code.ErrorCode.BATON_NOT_FOUND;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.coffeechat.domain.baton.dto.converter.BatonViewConverter;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingChatBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedChatBatonDTO;
import sideproject.coffeechat.domain.baton.dto.response.ChatBatonResponse;
import sideproject.coffeechat.domain.baton.dto.response.CompactBatonResponse;
import sideproject.coffeechat.domain.baton.entity.BatonType;
import sideproject.coffeechat.domain.baton.repository.BatonMapper;
import sideproject.coffeechat.global.response.exception.BatonException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BatonViewService {

    private final BatonMapper batonMapper;

    public List<CompactBatonResponse> getRequestedBatons(String username, int page, int size, BatonType batonType) {
        int offset = (page - 1) * size;
        List<RequestedBatonDTO> dtos = batonMapper.getRequestedBatons(username, batonType, size, offset);
        return BatonViewConverter.toRequestedBatonResponseList(dtos);
    }

    public List<CompactBatonResponse> getPendingBatons(String username, int page, int size, BatonType batonType) {
        int offset = (page - 1) * size;
        List<PendingBatonDTO> dtos = batonMapper.getPendingBatons(username, batonType, size, offset);
        return BatonViewConverter.toPendingBatonResponseList(dtos);
    }

    public ChatBatonResponse getRequestedChatBaton(Long batonId) {
        RequestedChatBatonDTO dto = batonMapper.getRequestedChatBaton(batonId);
        if (dto == null) {
            throw new BatonException(BATON_NOT_FOUND, "RequestedChatBaton NOT FOUND for batonId : " + batonId);
        }
        return BatonViewConverter.toRequestedChatBatonResponse(dto);
    }

    }

}
