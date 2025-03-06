package sideproject.coffeechat.domain.mentor.service;

import static sideproject.coffeechat.domain.baton.entity.BatonStatus.ACCEPTED;
import static sideproject.coffeechat.domain.baton.entity.BatonStatus.COMPLETED;
import static sideproject.coffeechat.domain.baton.entity.BatonStatus.REJECTED;
import static sideproject.coffeechat.domain.baton.entity.BatonStatus.REQUESTED;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.coffeechat.domain.baton.service.BatonViewService;
import sideproject.coffeechat.domain.member.entity.Worker;
import sideproject.coffeechat.domain.member.service.WorkerService;
import sideproject.coffeechat.domain.mentor.dto.converter.MentorConverter;
import sideproject.coffeechat.domain.mentor.dto.response.CompactMentorResponse;
import sideproject.coffeechat.domain.mentor.dto.response.MentorResponse;
import sideproject.coffeechat.domain.mentor.entity.Mentor;
import sideproject.coffeechat.domain.mentor.repository.MentorRepository;
import sideproject.coffeechat.global.response.code.ErrorCode;
import sideproject.coffeechat.global.response.exception.MentorException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentorViewService {

    private final MentorRepository mentorRepository;
    private final WorkerService workerService;
    private final BatonViewService batonViewService;

    public MentorResponse getMentor(Long mentorId) {
        Mentor mentor = mentorRepository.findWithAvailableSchedulesById(mentorId)
                .orElseThrow(() -> new MentorException(ErrorCode.MENTOR_NOT_FOUND));
        Worker worker = workerService.getWorkerById(mentor.getWorker().getId());

        Map<String, Long> countMap = batonViewService.getBatonStatusCounts(mentorId);
        Long mentoringCount = getMentoringCount(countMap);
        BigDecimal responseRate = getResponseRate(countMap);

        return MentorConverter.toMentorResponse(mentor, worker, mentoringCount, responseRate);
    }

    private BigDecimal getResponseRate(Map<String, Long> countMap) {
        Long totalCount = countMap.get(REQUESTED.getCountKey());
        if (totalCount == 0) {
            return BigDecimal.valueOf(100);
        }
        long responseCount = countMap.get(
                ACCEPTED.getCountKey()) + countMap.get(REJECTED.getCountKey()) + countMap.get(COMPLETED.getCountKey()
        );
        return BigDecimal.valueOf((double) responseCount / totalCount)
                .setScale(1, RoundingMode.HALF_UP);
    }

    private static Long getMentoringCount(Map<String, Long> countMap) {
        return countMap.get(REQUESTED.getCountKey());
    }

}
