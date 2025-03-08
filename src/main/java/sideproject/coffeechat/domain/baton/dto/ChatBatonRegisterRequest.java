package sideproject.coffeechat.domain.baton.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sideproject.coffeechat.domain.baton.entity.Charge;
import sideproject.coffeechat.global.validator.HasPriority;
import sideproject.coffeechat.global.validator.TimeRangeProvider;
import sideproject.coffeechat.global.validator.UniquePriority;
import sideproject.coffeechat.global.validator.ValidStartEndTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatBatonRegisterRequest {

    @NotNull
    private Charge charge;

    @NotNull
    @Size(max = 3)
    @Valid
    @UniquePriority(message = "TimeSlot priorities must be unique.")
    private List<TimeSlotRequest> availableSchedules;

    @NotNull
    private String preQuestion;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ValidStartEndTime
    public static class TimeSlotRequest implements HasPriority, TimeRangeProvider {

        @NotNull
        private LocalDate date;

        @NotNull
        private LocalTime startTime;

        @NotNull
        private LocalTime endTime;

        @NotNull
        private int priority;

    }

}
