package sideproject.coffeechat.domain.baton.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sideproject.coffeechat.domain.baton.dto.BatonConverter;
import sideproject.coffeechat.domain.baton.dto.BatonRegisterRequest;
import sideproject.coffeechat.domain.baton.entity.Baton;
import sideproject.coffeechat.domain.baton.entity.BatonTimeSlot;
import sideproject.coffeechat.domain.baton.repository.BatonRepository;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.member.service.MemberService;
import sideproject.coffeechat.domain.mentor.entity.Mentor;
import sideproject.coffeechat.domain.mentor.service.MentorService;
import sideproject.coffeechat.global.aws.S3Uploader;

@Service
@RequiredArgsConstructor
@Transactional
public class BatonService {

    private final MemberService memberService;
    private final MentorService mentorService;
    private final S3Uploader s3Uploader;
    private final BatonRepository batonRepository;

    public void register(Long mentorId, BatonRegisterRequest request, MultipartFile attachment, String username) {
        Member mentee = memberService.getMemberByUsername(username);
        Mentor mentor = mentorService.findByMentorId(mentorId);

        String attachmentUrl = uploadAttachment(attachment, mentee);
        saveBaton(request, attachmentUrl, mentor, mentee);
    }

    private void saveBaton(BatonRegisterRequest request, String attachmentUrl, Mentor mentor, Member mentee) {
        Baton baton = BatonConverter.toBaton(request, attachmentUrl, mentor, mentee);
        Baton savedBaton = batonRepository.save(baton);
        List<BatonTimeSlot> availableSchedules = BatonConverter
                .toBatonTimeSlotList(savedBaton, request.getAvailableSchedules());
        savedBaton.updateAvailableSchedules(availableSchedules);
    }

    private String uploadAttachment(MultipartFile attachment, Member mentee) {
        String prefix = mentee.getId() + "/baton/";
        return s3Uploader.upload(prefix, attachment);
    }

}
