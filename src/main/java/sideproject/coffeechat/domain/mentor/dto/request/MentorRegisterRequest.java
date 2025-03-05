package sideproject.coffeechat.domain.mentor.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private List<TimeSlotRequest> timeSlots;

    @NotNull
    private String shortDescription;

    @NotNull
    private String detailedDescription;

    @AssertTrue(message = "The priority values of TimeSlots must be unique.")
    public boolean isTimeSlotsPriorityUnique() {
        Set<Integer> prioritySet = new HashSet<>();
        for (TimeSlotRequest slot : timeSlots) {
            if (!prioritySet.add(slot.getPriority())) {
                return false;
            }
        }
        return true;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TimeSlotRequest {

        @NotNull
        private List<DayOfWeek> availableDays;

        @NotNull
        private LocalTime startTime;

        @NotNull
        private LocalTime endTime;

        @NotNull
        private int priority;

        @AssertTrue(message = "StartTime must be before EndTime")
        public boolean isValidTimeRange() {
            return startTime.isBefore(endTime);
        }
    }

}
