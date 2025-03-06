package sideproject.coffeechat.domain.mentor.dto.response;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MentorResponse {

    private Long mentorId;

    private String profileImageUrl;

    private String nickname;

    private String companyName;

    private String jobName;

    private String subJobName;

    private int careerYears;

    private String shortDescription;

    private String detailedDescription;

    private List<MentorTimeSlotResponse> availableSchedules;

    private Long mentoringCount;

    private BigDecimal responseRate;  // 소수점 1자리까지

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MentorTimeSlotResponse {

        private Long timeSlotId;

        private List<DayOfWeek> availableDays;

        private LocalTime startTime;

        private LocalTime endTime;

        private int priority;

    }

}
