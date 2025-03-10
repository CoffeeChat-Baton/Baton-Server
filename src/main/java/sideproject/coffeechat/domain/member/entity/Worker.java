package sideproject.coffeechat.domain.member.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue("WORKER")
public class Worker extends Member {

    private Long jobId;

    private String jobName;

    private Long subJobId;

    private String subJobName;

    private Integer careerYears;

    public void updateJob(Long jobId, String jobName) {
        this.jobId = jobId;
        this.jobName = jobName;
    }

    public void updateSubJob(Long subJobId, String subJobName) {
        this.subJobId = subJobId;
        this.subJobName = subJobName;
    }

    public void updateCareerYears(int careerYears) {
        this.careerYears = careerYears;
    }

}
