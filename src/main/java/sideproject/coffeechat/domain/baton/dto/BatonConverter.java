package sideproject.coffeechat.domain.baton.dto;

import java.util.List;
import sideproject.coffeechat.domain.baton.dto.ChatBatonRegisterRequest.TimeSlotRequest;
import sideproject.coffeechat.domain.baton.entity.BatonStatus;
import sideproject.coffeechat.domain.baton.entity.ChatBaton;
import sideproject.coffeechat.domain.baton.entity.ChatTimeSlot;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.mentor.entity.Mentor;

public class BatonConverter {

    public static ChatBaton toChatBaton(ChatBatonRegisterRequest request, String attachmentUrl, Mentor mentor, Member mentee) {
        return ChatBaton.builder()
                .charge(request.getCharge())
                .preQuestion(request.getPreQuestion())
                .attachmentUrl(attachmentUrl)
                .status(BatonStatus.REQUESTED)
                .mentor(mentor)
                .mentee(mentee)
                .build();
    }

    public static List<ChatTimeSlot> toBatonTimeSlotList(ChatBaton baton, List<TimeSlotRequest> request) {
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

}
