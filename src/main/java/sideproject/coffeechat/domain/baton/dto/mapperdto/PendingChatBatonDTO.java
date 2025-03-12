package sideproject.coffeechat.domain.baton.dto.mapperdto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import sideproject.coffeechat.domain.baton.entity.BatonType;
import sideproject.coffeechat.domain.baton.entity.ChatCharge;

@Getter
public class PendingChatBatonDTO {

    private Long batonId;

    private BatonType batonType;

    private ChatCharge charge;

    private String preQuestion;

    private String attachmentUrl;

    private LocalDateTime createdAt;

    private BatonMenteeDTO mentee;

    private List<ChatTimeSlotDTO> availableSchedules;

}
