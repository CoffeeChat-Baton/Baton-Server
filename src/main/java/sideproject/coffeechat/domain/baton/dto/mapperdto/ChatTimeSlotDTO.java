package sideproject.coffeechat.domain.baton.dto.mapperdto;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;

@Getter
public class ChatTimeSlotDTO {

    private Long timeSlotId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer priority;

}
