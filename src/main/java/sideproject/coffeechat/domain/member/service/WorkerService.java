package sideproject.coffeechat.domain.member.service;

import static sideproject.coffeechat.global.response.code.ErrorCode.JOB_NOT_FOUND;
import static sideproject.coffeechat.global.response.code.ErrorCode.JOB_REQUEST_ERROR;
import static sideproject.coffeechat.global.response.code.ErrorCode.SUB_JOB_NOT_FOUND;
import static sideproject.coffeechat.global.response.code.ErrorCode.WORKER_NOT_FOUND;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sideproject.coffeechat.domain.member.dto.converter.JobConverter;
import sideproject.coffeechat.domain.member.dto.request.WorkerJoinRequest;
import sideproject.coffeechat.domain.member.dto.response.JobResponse;
import sideproject.coffeechat.domain.member.dto.response.SubJobResponse;
import sideproject.coffeechat.domain.member.entity.Job;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.member.entity.SubJob;
import sideproject.coffeechat.domain.member.entity.Worker;
import sideproject.coffeechat.domain.member.repository.JobRepository;
import sideproject.coffeechat.domain.member.repository.SubJobRepository;
import sideproject.coffeechat.domain.member.repository.WorkerMapper;
import sideproject.coffeechat.domain.member.repository.WorkerRepository;
import sideproject.coffeechat.global.aws.S3Uploader;
import sideproject.coffeechat.global.response.code.ErrorCode;
import sideproject.coffeechat.global.response.exception.MemberException;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkerService {

    private static final String ETC = "기타";

    private final MemberService memberService;
    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;
    private final JobRepository jobRepository;
    private final SubJobRepository subJobRepository;
    private final S3Uploader s3Uploader;

    public void join(WorkerJoinRequest request, MultipartFile profileImage, String username) {
        Member member = memberService.getMemberByUsername(username);
        saveWorker(request, member);
        uploadProfileImage(member, profileImage);
    }

    private void saveWorker(WorkerJoinRequest request, Member member) {
        Map<String, String> jobNames = validateAndGetCustomJobNames(
                request.getJobId(), request.getCustomJobName(),
                request.getSubJobId(), request.getCustomSubJobName()
        );
        workerMapper.joinWorker(
                member.getId(),
                request.getNickname(),
                request.getJobId(), jobNames.get("jobName"),
                request.getSubJobId(), jobNames.get("subJobName"),
                request.getCareerYears(),
                request.getEmail()
        );
    }

    private void uploadProfileImage(Member member, MultipartFile profileImage) {
        String prefix = member.getId() + "/profile/";
        String profileImageUrl = s3Uploader.upload(prefix, profileImage);
        member.updateProfileImageUrl(profileImageUrl);
    }

    @Transactional(readOnly = true)
    public List<JobResponse> getJobs() {
        List<Job> jobs = jobRepository.findAll(Sort.by(Direction.ASC, "id"));
        return JobConverter.toJobResponseList(jobs);
    }

    @Transactional(readOnly = true)
    public List<SubJobResponse> getSubJobsByJobId(Long jobId) {
        List<SubJob> subJobs = subJobRepository.findByJobIdOrderByIdAsc(jobId);
        return JobConverter.toSubJobResponseList(subJobs);
    }

    public Map<String, String> validateAndGetCustomJobNames(Long jobId, String customJobName,
                                                            Long subJobId, String customSubJobName) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new MemberException(JOB_NOT_FOUND));
        SubJob subJob = subJobRepository.findById(subJobId)
                .orElseThrow(() -> new MemberException(SUB_JOB_NOT_FOUND));

        if (!subJob.getJob().getId().equals(jobId)) {
            throw new MemberException(JOB_REQUEST_ERROR, "This SubJob does not belong to this Job");
        }

        return validateCustomJobNames(job, customJobName, subJob, customSubJobName);
    }

    private static Map<String, String> validateCustomJobNames(Job job, String customJobName,
                                                              SubJob subJob, String customSubJobName) {
        boolean isJobEtc = job.getJobName().equals(ETC);
        boolean isSubJobEtc = subJob.getSubJobName().equals(ETC);

        if (isJobEtc && customJobName == null) {
            throw new MemberException(JOB_REQUEST_ERROR, "CustomJobName is required");
        }
        if (isSubJobEtc && customSubJobName == null) {
            throw new MemberException(JOB_REQUEST_ERROR, "CustomSubJobName is required");
        }

        return Map.of(
                "jobName", isJobEtc ? customJobName : job.getJobName(),
                "subJobName", isSubJobEtc ? customSubJobName : subJob.getSubJobName()
        );
    }

    public Worker validateWorker(String username) {
        return workerRepository.findByUsername(username)
                .orElseThrow(() -> new MemberException(ErrorCode.WORKER_NOT_FOUND,
                        "Member should be WORKER to apply mentor"));
    }

    public Worker getWorkerById(Long workerId) {
        return workerRepository.findById(workerId)
                .orElseThrow(() -> new MemberException(WORKER_NOT_FOUND));
    }

}
