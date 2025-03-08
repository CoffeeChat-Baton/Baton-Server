package sideproject.coffeechat.domain.baton.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sideproject.coffeechat.domain.baton.dto.BatonConverter;
import sideproject.coffeechat.domain.baton.dto.ChatBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.entity.ChatBaton;
import sideproject.coffeechat.domain.baton.entity.ChatTimeSlot;
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

    public void registerChatBaton(Long mentorId, ChatBatonRegisterRequest request, MultipartFile attachment, String username) {
        Member mentee = memberService.getMemberByUsername(username);
        Mentor mentor = mentorService.findByMentorId(mentorId);

        String attachmentUrl = uploadAttachment(attachment, mentee);
        saveChatBaton(request, attachmentUrl, mentor, mentee);
    }

    private void saveChatBaton(ChatBatonRegisterRequest request, String attachmentUrl, Mentor mentor, Member mentee) {
        ChatBaton chatBaton = BatonConverter.toChatBaton(request, attachmentUrl, mentor, mentee);
        ChatBaton savedBaton = (ChatBaton) batonRepository.save(chatBaton);
        List<ChatTimeSlot> availableSchedules = BatonConverter
                .toBatonTimeSlotList(savedBaton, request.getAvailableSchedules());
        savedBaton.updateAvailableSchedules(availableSchedules);
    }

    private String uploadAttachment(MultipartFile attachment, Member mentee) {
        String prefix = mentee.getId() + "/baton/";
        return s3Uploader.upload(prefix, attachment);
    }

}
