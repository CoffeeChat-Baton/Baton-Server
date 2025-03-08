package sideproject.coffeechat.domain.mentor.dto.mapperdto;

import java.time.LocalTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MentorDTO {

    private Long mentorId;

    private String profileImageUrl;

    private String nickname;

    private String companyName;

    private String jobName;

    private String subJobName;

    private int careerYears;

    private String shortDescription;

    private String detailedDescription;

    private Long mentoringCount;

    private Double responseRate;  // 소수점 1자리까지

    private boolean isBookmarked;

    private List<MentorTimeSlotDTO> availableSchedules;

    @Getter
    @NoArgsConstructor
    public static class MentorTimeSlotDTO {

        private Long timeSlotId;

        private LocalTime startTime;

        private LocalTime endTime;

        private int priority;

        private List<String> availableDays;

    }

}
