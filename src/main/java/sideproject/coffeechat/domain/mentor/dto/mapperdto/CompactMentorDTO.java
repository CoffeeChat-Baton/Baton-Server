package sideproject.coffeechat.domain.mentor.dto.mapperdto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CompactMentorDTO {

    // Member
    private String nickname;
    private String profileImageUrl;

    // Worker
    private String companyName;
    private String jobName;
    private String subJobName;
    private int careerYears;

    // Mentor
    private Long mentorId;
    private String shortDescription;

    // Baton
    private long mentoringCount;
    private Double responseRate;

    // Bookmark
    private boolean isBookmarked;

    // SortBy
    private LocalDateTime updatedAt;
    private long popularityScore;

}
