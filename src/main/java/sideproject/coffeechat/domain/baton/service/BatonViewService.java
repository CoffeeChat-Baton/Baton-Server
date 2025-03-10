package sideproject.coffeechat.domain.baton.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.coffeechat.domain.baton.dto.converter.BatonConverter;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedBatonDTO;
import sideproject.coffeechat.domain.baton.dto.response.CompactBatonResponse;
import sideproject.coffeechat.domain.baton.entity.BatonType;
import sideproject.coffeechat.domain.baton.repository.BatonMapper;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.member.service.MemberService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BatonViewService {

    private final BatonMapper batonMapper;
    private final MemberService memberService;

    public List<CompactBatonResponse> getRequestedBatons(String username, int page, int size, BatonType batonType) {
        Member member = memberService.getMemberByUsername(username);
        int offset = (page - 1) * size;
        List<RequestedBatonDTO> requestedBatonDTOs = batonMapper.getRequestedBatons(
                member.getId(), batonType, size, offset);
        return BatonConverter.toRequestedBatonsResponse(requestedBatonDTOs);
    }

}
