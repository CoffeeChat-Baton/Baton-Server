package sideproject.coffeechat.domain.baton.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sideproject.coffeechat.domain.baton.entity.BatonType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PortfolioBatonResponse {

    private Long batonId;

    private BatonType batonType;

    private LocalDateTime dueTime;

    private BatonMentorResponse mentor;

    private BatonMenteeResponse mentee;

    private LocalDate deadline;

    private String questionContent;

    private String attachmentUrl;

    private Integer fee;

    private String feedback;

}
