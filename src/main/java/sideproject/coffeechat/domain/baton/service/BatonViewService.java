package sideproject.coffeechat.domain.baton.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.coffeechat.domain.baton.dto.converter.BatonConverter;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedBatonDTO;
import sideproject.coffeechat.domain.baton.dto.response.ChatBatonResponse;
import sideproject.coffeechat.domain.baton.dto.response.CompactBatonResponse;
import sideproject.coffeechat.domain.baton.entity.BatonType;
import sideproject.coffeechat.domain.baton.repository.BatonMapper;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BatonViewService {

    private final BatonMapper batonMapper;

    public List<CompactBatonResponse> getRequestedBatons(String username, int page, int size, BatonType batonType) {
        int offset = (page - 1) * size;
        List<RequestedBatonDTO> requestedBatonDTOs = batonMapper.getRequestedBatons(
                username, batonType, size, offset);
        return BatonConverter.toRequestedBatonsResponse(requestedBatonDTOs);
    }

    public List<CompactBatonResponse> getPendingBatons(String username, int page, int size, BatonType batonType) {
        int offset = (page - 1) * size;
        List<PendingBatonDTO> pendingBatonDTOs = batonMapper.getPendingBatons(
                username, batonType, size, offset);
        return BatonConverter.toPendingBatonsResponse(pendingBatonDTOs);
    }

}
