package sideproject.coffeechat.domain.mentor.service;

import jakarta.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sideproject.coffeechat.domain.member.entity.Role;
import sideproject.coffeechat.domain.member.entity.Worker;
import sideproject.coffeechat.domain.member.service.WorkerService;
import sideproject.coffeechat.domain.mentor.dto.converter.MentorConverter;
import sideproject.coffeechat.domain.mentor.dto.request.MentorRegisterRequest;
import sideproject.coffeechat.domain.mentor.entity.Mentor;
import sideproject.coffeechat.domain.mentor.entity.MentorTimeSlot;
import sideproject.coffeechat.domain.mentor.repository.MentorRepository;
import sideproject.coffeechat.global.response.code.ErrorCode;
import sideproject.coffeechat.global.response.exception.MentorException;

@Service
@RequiredArgsConstructor
@Transactional
public class MentorService {

    private final WorkerService workerService;
    private final MentorRepository mentorRepository;
    public void create(String companyName, String username) {
        Worker worker = workerService.validateWorker(username);
        worker.addRole(Role.ROLE_MENTOR);

        mentorRepository.save(
                Mentor.builder()
                .companyName(companyName)
                .worker(worker)
                .build()
        );
    }


}
