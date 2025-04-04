package sideproject.coffeechat.domain.member.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sideproject.coffeechat.domain.member.dto.request.WorkerJoinRequest;
import sideproject.coffeechat.domain.member.dto.response.JobResponse;
import sideproject.coffeechat.domain.member.dto.response.SubJobResponse;
import sideproject.coffeechat.domain.member.service.WorkerService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/worker")
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping("/join")
    public Response<Void> joinWorker(
            @RequestPart @Valid WorkerJoinRequest request,
            @RequestPart(required = false) MultipartFile profileImage,
            Authentication authentication
    ) {
        workerService.join(request, profileImage, authentication.getName());
        return Response.success();
    }

    @GetMapping("/job-list")
    public Response<List<JobResponse>> getJobs() {
        return Response.success(workerService.getJobs());
    }

    @GetMapping("/subjob-list/{jobId}")
    public Response<List<SubJobResponse>> getSubJobsByJobId(@PathVariable Long jobId) {
        return Response.success(workerService.getSubJobsByJobId(jobId));
    }

}
