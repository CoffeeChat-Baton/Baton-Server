package sideproject.coffeechat.domain.baton.dto.converter;

import static sideproject.coffeechat.domain.member.entity.MemberType.STUDENT;
import static sideproject.coffeechat.domain.member.entity.MemberType.WORKER;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import sideproject.coffeechat.domain.baton.dto.mapperdto.BatonMenteeDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.BatonMentorDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.ChatTimeSlotDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.PendingChatBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedBatonDTO;
import sideproject.coffeechat.domain.baton.dto.mapperdto.RequestedChatBatonDTO;
import sideproject.coffeechat.domain.baton.dto.response.BatonMenteeResponse;
import sideproject.coffeechat.domain.baton.dto.response.BatonMentorResponse;
import sideproject.coffeechat.domain.baton.dto.response.ChatBatonResponse;
import sideproject.coffeechat.domain.baton.dto.response.ChatTimeSlotResponse;
import sideproject.coffeechat.domain.baton.dto.response.CompactBatonResponse;
import sideproject.coffeechat.domain.member.entity.MemberType;
import sideproject.coffeechat.global.Constants;

public class BatonViewConverter {

    public static List<CompactBatonResponse> toRequestedBatonResponseList(List<RequestedBatonDTO> dtos) {
        return dtos.stream()
                .map(dto -> {
                    return CompactBatonResponse.builder()
                            .batonId(dto.getBatonId())
                            .batonType(dto.getBatonType())
                            .chatBatonDuration(dto.getChatBatonDuration())
                            .profileImageUrl(dto.getProfileImageUrl())
                            .nickname(dto.getNickname())
                            .companyName(dto.getCompanyName())
                            .division(dto.getJobName())
                            .section(dto.getSubJobName())
                            .careerYears(dto.getCareerYears())
                            .build();
                }).toList();
    }

    public static List<CompactBatonResponse> toPendingBatonResponseList(List<PendingBatonDTO> dtos) {
        return dtos.stream()
                .map(dto -> {
                    MemberType memberType = dto.getMemberType();
                    LocalDateTime dueDate = calculateDueDate(dto.getCreatedAt());
                    long dueInDays = Math.max(ChronoUnit.DAYS.between(LocalDateTime.now(), dueDate), 0);

                    return CompactBatonResponse.builder()
                            .batonId(dto.getBatonId())
                            .batonType(dto.getBatonType())
                            .chatBatonDuration(dto.getChatBatonDuration())
                            .memberType(memberType)
                            .profileImageUrl(dto.getProfileImageUrl())
                            .nickname(dto.getNickname())
                            .division(getDivision(memberType, dto.getEducationName(), dto.getJobName()))
                            .section(getSection(memberType, dto.getMajorName(), dto.getSubJobName()))
                            .careerYears(dto.getCareerYears())
                            .dueInDays(dueInDays)
                            .build();
                }).toList();
    }

    private static LocalDateTime calculateDueDate(LocalDateTime createdAt) {
        return createdAt.plusHours(Constants.PENDING_BATON_EXPIRATION_HOURS);
    }

    private static String getDivision(MemberType memberType, String educationName, String jobName) {
        if (memberType == STUDENT) {
            return educationName;
        }
        if (memberType == WORKER) {
            return jobName;
        }
        throw new IllegalArgumentException("Unsupported memberType: " + memberType);
    }

    private static String getSection(MemberType memberType, String majorName, String subJobName) {
        if (memberType == STUDENT) {
            return majorName;
        }
        if (memberType == WORKER) {
            return subJobName;
        }
        throw new IllegalArgumentException("Unsupported memberType: " + memberType);
    }

}
