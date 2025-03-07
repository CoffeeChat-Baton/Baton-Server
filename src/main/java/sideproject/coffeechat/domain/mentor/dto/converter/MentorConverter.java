package sideproject.coffeechat.domain.mentor.dto.converter;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import sideproject.coffeechat.domain.member.entity.Worker;
import sideproject.coffeechat.domain.mentor.dto.CompactMentorDTO;
import sideproject.coffeechat.domain.mentor.dto.request.MentorRegisterRequest.TimeSlotRequest;
import sideproject.coffeechat.domain.mentor.dto.response.CompactMentorResponse;
import sideproject.coffeechat.domain.mentor.dto.response.MentorResponse;
import sideproject.coffeechat.domain.mentor.dto.response.MentorResponse.MentorTimeSlotResponse;
import sideproject.coffeechat.domain.mentor.entity.Mentor;
import sideproject.coffeechat.domain.mentor.entity.MentorTimeSlot;

public class MentorConverter {

    public static List<MentorTimeSlot> toMentorTimeSlotList(List<TimeSlotRequest> request, Mentor mentor) {
        return request.stream()
                .map(timeSlot -> {
                            return MentorTimeSlot.builder()
                                    .mentor(mentor)
                                    .availableDays(timeSlot.getAvailableDays())
                                    .startTime(timeSlot.getStartTime())
                                    .endTime(timeSlot.getEndTime())
                                    .priority(timeSlot.getPriority())
                                    .build();
                }).toList();
    }

    public static MentorResponse toMentorResponse(
            Mentor mentor, Worker worker, Long mentoringCount, BigDecimal responseRate
    ) {
        return MentorResponse.builder()
                .mentorId(mentor.getId())
                .profileImageUrl(mentor.getWorker().getProfileImageUrl())
                .nickname(mentor.getWorker().getNickname())
                .companyName(mentor.getCompanyName())
                .jobName(worker.getJobName())
                .subJobName(worker.getSubJobName())
                .careerYears(worker.getCareerYears())
                .mentoringCount(mentoringCount)
                .responseRate(responseRate)
                .shortDescription(mentor.getShortDescription())
                .detailedDescription(mentor.getDetailedDescription())
                .availableSchedules(toMentorTimeSlotResponses(mentor.getAvailableSchedules()))
                .build();
    }

    private static List<MentorTimeSlotResponse> toMentorTimeSlotResponses(List<MentorTimeSlot> timeSlots) {
        return timeSlots.stream()
                .sorted(Comparator.comparing(MentorTimeSlot::getPriority))
                .map(timeSlot -> {
                    return new MentorTimeSlotResponse(
                            timeSlot.getId(),
                            timeSlot.getAvailableDays(),
                            timeSlot.getStartTime(),
                            timeSlot.getEndTime(),
                            timeSlot.getPriority()
                    );
                }).toList();
    }

    public static List<CompactMentorResponse> toCompactMentorResponses(List<CompactMentorDTO> dtos) {
        return dtos.stream()
                .map(dto -> {
                    return CompactMentorResponse.builder()
                            .mentorId(dto.getMentorId())
                            .profileImageUrl(dto.getProfileImageUrl())
                            .nickname(dto.getNickname())
                            .companyName(dto.getCompanyName())
                            .jobName(dto.getJobName())
                            .subJobName(dto.getSubJobName())
                            .careerYears(dto.getCareerYears())
                            .shortDescription(dto.getShortDescription())
                            .mentoringCount(dto.getMentoringCount())
                            .responseRate(dto.getResponseRate())
                            .isBookmarked(dto.isBookmarked())
                            .build();
                }).toList();
    }
}
