package sideproject.coffeechat.domain.baton.dto.converter;

import static sideproject.coffeechat.domain.baton.entity.BatonStatus.REQUESTED;

import java.util.List;
import sideproject.coffeechat.domain.baton.dto.request.ChatBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.dto.request.ChatBatonRegisterRequest.TimeSlotRequest;
import sideproject.coffeechat.domain.baton.dto.request.PortfolioBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.dto.request.ResumeBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.entity.ChatBaton;
import sideproject.coffeechat.domain.baton.entity.ChatTimeSlot;
import sideproject.coffeechat.domain.baton.entity.PortfolioBaton;
import sideproject.coffeechat.domain.baton.entity.PortfolioCharge;
import sideproject.coffeechat.domain.baton.entity.ResumeBaton;
import sideproject.coffeechat.domain.baton.entity.ResumeCharge;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.mentor.entity.Mentor;

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
                .charge(PortfolioCharge.BASIC)
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
                .charge(ResumeCharge.BASIC)
                .attachmentUrl(attachmentUrl)
                .status(REQUESTED)
                .mentor(mentor)
                .mentee(mentee)
                .build();
    }

}
