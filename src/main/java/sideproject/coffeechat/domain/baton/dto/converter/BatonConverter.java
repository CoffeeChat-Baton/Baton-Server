package sideproject.coffeechat.domain.baton.dto.converter;

import static sideproject.coffeechat.domain.baton.entity.BatonStatus.REQUESTED;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedBatonDTO;
import sideproject.coffeechat.domain.baton.dto.request.ChatBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.dto.request.ChatBatonRegisterRequest.TimeSlotRequest;
import sideproject.coffeechat.domain.baton.dto.request.PortfolioBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.dto.request.ResumeBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.dto.response.CompactBatonResponse;
import sideproject.coffeechat.domain.baton.entity.ChatBaton;
import sideproject.coffeechat.domain.baton.entity.ChatTimeSlot;
import sideproject.coffeechat.domain.baton.entity.PortfolioBaton;
import sideproject.coffeechat.domain.baton.entity.ResumeBaton;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.mentor.entity.Mentor;
import sideproject.coffeechat.global.Constants;

public class BatonConverter {

    public static ChatBaton toChatBaton(
            ChatBatonRegisterRequest request, String attachmentUrl, Mentor mentor, Member mentee
    ) {
        return ChatBaton.builder()
                .charge(request.getCharge())
                .preQuestion(request.getPreQuestion())
                .attachmentUrl(attachmentUrl)
                .status(REQUESTED)
                .mentor(mentor)
                .mentee(mentee)
                .build();
    }

    public static List<ChatTimeSlot> toChatTimeSlots(ChatBaton baton, List<TimeSlotRequest> request) {
        return request.stream()
                .map(timeSlot -> {
                    return ChatTimeSlot.builder()
                            .baton(baton)
                            .date(timeSlot.getDate())
                            .startTime(timeSlot.getStartTime())
                            .endTime(timeSlot.getEndTime())
                            .priority(timeSlot.getPriority())
                            .build();
                }).toList();
    }

    public static PortfolioBaton toPortfolioBaton(
            PortfolioBatonRegisterRequest request, String attachmentUrl, Mentor mentor, Member mentee
    ) {
        return PortfolioBaton.builder()
                .deadline(request.getDeadline())
                .questionContent(request.getQuestionContent())
                .attachmentUrl(attachmentUrl)
                .status(REQUESTED)
                .mentor(mentor)
                .mentee(mentee)
                .build();
    }

    public static ResumeBaton toResumeBaton(
            ResumeBatonRegisterRequest request, String attachmentUrl, Mentor mentor, Member mentee
    ) {
        return ResumeBaton.builder()
                .deadline(request.getDeadline())
                .questionContent(request.getQuestionContent())
                .attachmentUrl(attachmentUrl)
                .status(REQUESTED)
                .mentor(mentor)
                .mentee(mentee)
                .build();
    }

    public static List<CompactBatonResponse> toRequestedBatonsResponse(List<RequestedBatonDTO> dtos) {
        return dtos.stream()
                .map(dto -> {
                    return CompactBatonResponse.builder()
                            .batonId(dto.getBatonId())
                            .batonType(dto.getBatonType())
                            .chatBatonDuration(dto.getChatBatonDuration())
                            .profileImageUrl(dto.getProfileImageUrl())
                            .nickname(dto.getNickname())
                            .companyName(dto.getCompanyName())
                            .section(dto.getJobName())
                            .division(dto.getSubJobName())
                            .careerYears(dto.getCareerYears())
                            .build();
                }).toList();
    }

    public static List<CompactBatonResponse> toPendingBatonsResponse(List<PendingBatonDTO> dtos) {
        return dtos.stream()
                .map(dto -> {
                    long dueInDays = calculateDueInDays(dto.getCreatedAt());
                    return CompactBatonResponse.builder()
                            .batonId(dto.getBatonId())
                            .batonType(dto.getBatonType())
                            .chatBatonDuration(dto.getChatBatonDuration())
                            .profileImageUrl(dto.getProfileImageUrl())
                            .nickname(dto.getNickname())
                            // 학생 → 학력 | 직장인 → 직무
                            .section(dto.getEducationName() != null ? dto.getEducationName() : dto.getJobName())
                            // 학생 → 전공 | 직장인 → 세부 직무
                            .division(dto.getMajorName() != null ? dto.getMajorName() : dto.getSubJobName())
                            .careerYears(dto.getCareerYears())
                            .dueInDays(dueInDays)
                            .build();
                }).toList();
    }

    private static long calculateDueInDays(LocalDateTime createdAt) {
        LocalDateTime dueDate = createdAt.plusHours(Constants.PENDING_BATON_EXPIRATION_HOURS);
        long daysLeft = ChronoUnit.DAYS.between(LocalDateTime.now(), dueDate);
        return Math.max(daysLeft, 0);
    }

}
