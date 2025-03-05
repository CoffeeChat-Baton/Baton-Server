package sideproject.coffeechat.domain.member.dto.converter;

import java.util.List;
import java.util.stream.Collectors;
import sideproject.coffeechat.domain.member.dto.response.JobResponse;
import sideproject.coffeechat.domain.member.dto.response.SubJobResponse;
import sideproject.coffeechat.domain.member.entity.Job;
import sideproject.coffeechat.domain.member.entity.SubJob;

public class JobConverter {

    public static List<JobResponse> toJobResponseList(List<Job> jobs) {
        return jobs.stream()
                .map(job -> new JobResponse(job.getId(), job.getJobName()))
                .collect(Collectors.toList());
    }

    public static List<SubJobResponse> toSubJobResponseList(List<SubJob> subJobs) {
        return subJobs.stream()
                .map(subJob -> new SubJobResponse(
                        subJob.getJob().getId(), subJob.getId(), subJob.getSubJobName()))
                .collect(Collectors.toList());
    }

}
