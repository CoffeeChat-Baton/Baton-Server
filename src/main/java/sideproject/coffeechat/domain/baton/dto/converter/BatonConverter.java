package sideproject.coffeechat.domain.baton.dto.converter;

import static sideproject.coffeechat.domain.baton.entity.BatonStatus.REQUESTED;
import static sideproject.coffeechat.domain.member.entity.MemberType.*;

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
import sideproject.coffeechat.domain.baton.dto.request.ChatBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.dto.request.ChatBatonRegisterRequest.TimeSlotRequest;
import sideproject.coffeechat.domain.baton.dto.request.PortfolioBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.dto.request.ResumeBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.dto.response.BatonMenteeResponse;
import sideproject.coffeechat.domain.baton.dto.response.BatonMentorResponse;
import sideproject.coffeechat.domain.baton.dto.response.ChatBatonResponse;
import sideproject.coffeechat.domain.baton.dto.response.ChatTimeSlotResponse;
import sideproject.coffeechat.domain.baton.dto.response.CompactBatonResponse;
import sideproject.coffeechat.domain.baton.entity.ChatBaton;
import sideproject.coffeechat.domain.baton.entity.ChatTimeSlot;
import sideproject.coffeechat.domain.baton.entity.PortfolioBaton;
import sideproject.coffeechat.domain.baton.entity.ResumeBaton;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.member.entity.MemberType;
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

}
