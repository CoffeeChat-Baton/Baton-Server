package sideproject.coffeechat.domain.baton.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sideproject.coffeechat.domain.baton.entity.BatonType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatBatonResponse {

    private Long batonId;

    private BatonType batonType;

    private LocalDateTime dueTime;

    private BatonMentorResponse mentor;

    private BatonMenteeResponse mentee;

    private String chatBatonDuration;

    private List<ChatTimeSlotResponse> availableSchedules;

    private String preQuestion;

    private String attachmentUrl;

    private Integer fee;

}
