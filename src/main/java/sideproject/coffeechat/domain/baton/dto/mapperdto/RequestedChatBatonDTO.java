package sideproject.coffeechat.domain.baton.dto.mapperdto;

import java.util.List;
import lombok.Getter;
import sideproject.coffeechat.domain.baton.entity.BatonType;
import sideproject.coffeechat.domain.baton.entity.Charge;

@Getter
public class RequestedChatBatonDTO {

    private Long batonId;

    private BatonType batonType;

    private Charge charge;

    private String preQuestion;

    private String attachmentUrl;

    private BatonMentorDTO mentor;

    private List<ChatTimeSlotDTO> availableSchedules;

}
