package sideproject.coffeechat.domain.mentor.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.member.service.MemberService;
import sideproject.coffeechat.domain.mentor.dto.converter.MentorConverter;
import sideproject.coffeechat.domain.mentor.dto.mapperdto.CompactMentorDTO;
import sideproject.coffeechat.domain.mentor.dto.mapperdto.MentorDTO;
import sideproject.coffeechat.domain.mentor.dto.response.CompactMentorResponse;
import sideproject.coffeechat.domain.mentor.dto.response.MentorResponse;
import sideproject.coffeechat.domain.mentor.entity.SortBy;
import sideproject.coffeechat.domain.mentor.repository.MentorMapper;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentorViewService {

    private final MentorMapper mentorMapper;
    private final MemberService memberService;

    public MentorResponse getMentor(Long mentorId) {
        MentorDTO mentorDTO = mentorMapper.findMentorDetailsById(mentorId);
        return MentorConverter.toMentorResponse(mentorDTO);
    }

    public List<CompactMentorResponse> getMentorsInJob(
            Long jobId, Long subJobId, String username, int page, int size, SortBy sortBy
    ) {
        Member member = memberService.getMemberByUsername(username);
        int offset = (page - 1) * size;
        List<CompactMentorDTO> compactMentorDTOS = mentorMapper.findMentorsByJobId(
                jobId, subJobId, member.getId(), size, offset, sortBy.getValue());

        return MentorConverter.toCompactMentorResponses(compactMentorDTOS);
    }

}
