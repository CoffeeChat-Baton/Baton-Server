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
    private final EmailService emailService;

    public void sendEmailToAdmin(MultipartFile file, String username) throws MessagingException, IOException {
        workerService.validateWorker(username);
        emailService.sendEmailWithAttachment("imhajung@gmail.com", file);
    }

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

    public void register(MentorRegisterRequest request, String username) {
        Worker worker = workerService.validateWorker(username);
        updateWorkerInfo(request, worker);

        Mentor mentor = findByWorkerId(worker.getId());
        updateMentorInfo(request, mentor);
    }

    private void updateWorkerInfo(MentorRegisterRequest request, Worker worker) {
        Map<String, String> jobNames = workerService.validateAndGetCustomJobNames(
                request.getJobId(), request.getCustomJobName(),
                request.getSubJobId(), request.getCustomSubJobName()
        );

        worker.updateJob(request.getJobId(), jobNames.get("jobName"));
        worker.updateSubJob(request.getSubJobId(), jobNames.get("subJobName"));
        worker.updateCareerYears(request.getCareerYears());
    }

    private void updateMentorInfo(MentorRegisterRequest request, Mentor mentor) {
        List<MentorTimeSlot> availableSchedules = MentorConverter
                .toMentorTimeSlotList(request.getAvailableSchedules(), mentor);
        mentor.updateShortDescription(request.getShortDescription());
        mentor.updateDetailedDescription(request.getDetailedDescription());
        mentor.updateAvailableSchedules(availableSchedules);
    }

    public Mentor findByWorkerId(Long workerId) {
        return mentorRepository.findByWorkerId(workerId)
                .orElseThrow(() -> new MentorException(ErrorCode.MENTOR_NOT_FOUND, "Not Registered Mentor"));
    }

    public Mentor findByMentorId(Long mentorId) {
        return mentorRepository.findById(mentorId)
                .orElseThrow(() -> new MentorException(ErrorCode.MENTOR_NOT_FOUND, "Not Registered Mentor"));
    }

}
