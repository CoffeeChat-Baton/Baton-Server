package sideproject.coffeechat.domain.mentor.dto.converter;

import java.util.List;
import sideproject.coffeechat.domain.mentor.dto.mapperdto.CompactMentorDTO;
import sideproject.coffeechat.domain.mentor.dto.mapperdto.MentorDTO;
import sideproject.coffeechat.domain.mentor.dto.mapperdto.MentorDTO.MentorTimeSlotDTO;
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

    public static MentorResponse toMentorResponse(MentorDTO dto) {
        return MentorResponse.builder()
                .mentorId(dto.getMentorId())
                .profileImageUrl(dto.getProfileImageUrl())
                .nickname(dto.getNickname())
                .companyName(dto.getCompanyName())
                .jobName(dto.getJobName())
                .subJobName(dto.getSubJobName())
                .careerYears(dto.getCareerYears())
                .mentoringCount(dto.getMentoringCount())
                .responseRate(dto.getResponseRate())
                .shortDescription(dto.getShortDescription())
                .detailedDescription(dto.getDetailedDescription())
                .availableSchedules(toMentorTimeSlotResponse(dto.getAvailableSchedules()))
                .isBookmarked(dto.isBookmarked())
                .build();
    }

    private static List<MentorTimeSlotResponse> toMentorTimeSlotResponse(List<MentorTimeSlotDTO> dtos) {
        return dtos.stream()
                .map(dto -> {
                    return MentorTimeSlotResponse.builder()
                            .timeSlotId(dto.getTimeSlotId())
                            .availableDays(dto.getAvailableDays())
                            .startTime(dto.getStartTime())
                            .endTime(dto.getEndTime())
                            .priority(dto.getPriority())
                            .build();
                }).toList();
    }
}
