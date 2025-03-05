package sideproject.coffeechat.domain.mentor.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sideproject.coffeechat.global.validator.HasPriority;
import sideproject.coffeechat.global.validator.TimeRangeProvider;
import sideproject.coffeechat.global.validator.UniquePriority;
import sideproject.coffeechat.global.validator.ValidStartEndTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MentorRegisterRequest {

    @NotNull
    private Long jobId;

    // Job 이 "기타"인 경우만 필요
    private String customJobName;

    @NotNull
    private Long subJobId;

    // SubJob 이 "기타"인 경우만 필요
    private String customSubJobName;

    @NotNull
    private Integer careerYears;

    @NotNull
    @Size(max = 3)
    @Valid
    @UniquePriority(message = "TimeSlot priorities must be unique.")
    private List<TimeSlotRequest> availableSchedules;

    @NotNull
    private String shortDescription;

    @NotNull
    private String detailedDescription;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ValidStartEndTime
    public static class TimeSlotRequest implements HasPriority, TimeRangeProvider {

        @NotNull
        private List<DayOfWeek> availableDays;

        @NotNull
        private LocalTime startTime;

        @NotNull
        private LocalTime endTime;

        @NotNull
        private int priority;

    }

}
