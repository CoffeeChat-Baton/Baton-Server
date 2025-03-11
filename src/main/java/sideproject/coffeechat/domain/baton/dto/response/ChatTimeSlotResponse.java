package sideproject.coffeechat.domain.baton.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatTimeSlotResponse {

    private Long timeSlotId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer priority;

}
