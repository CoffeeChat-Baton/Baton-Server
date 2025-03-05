package sideproject.coffeechat.domain.baton.dto;

import java.util.List;
import sideproject.coffeechat.domain.baton.dto.BatonRegisterRequest.TimeSlotRequest;
import sideproject.coffeechat.domain.baton.entity.Baton;
import sideproject.coffeechat.domain.baton.entity.BatonStatus;
import sideproject.coffeechat.domain.baton.entity.BatonTimeSlot;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.mentor.entity.Mentor;

public class BatonConverter {

    public static Baton toBaton(BatonRegisterRequest request, String attachmentUrl, Mentor mentor, Member mentee) {
        return Baton.builder()
                .charge(request.getCharge())
                .preQuestion(request.getPreQuestion())
                .attachmentUrl(attachmentUrl)
                .status(BatonStatus.REQUESTED)
                .mentor(mentor)
                .mentee(mentee)
                .build();
    }

    public static List<BatonTimeSlot> toBatonTimeSlotList(Baton baton, List<TimeSlotRequest> request) {
        return request.stream()
                .map(timeSlot -> {
                    return BatonTimeSlot.builder()
                            .baton(baton)
                            .date(timeSlot.getDate())
                            .startTime(timeSlot.getStartTime())
                            .endTime(timeSlot.getEndTime())
                            .priority(timeSlot.getPriority())
                            .build();
                }).toList();
    }

}
