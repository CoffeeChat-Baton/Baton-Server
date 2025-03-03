package sideproject.coffeechat.domain.member.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Response<Void> joinWorker(@RequestBody @Valid WorkerJoinRequest request, Authentication authentication) {
        workerService.join(request, authentication.getName());
        return Response.success();
    }


}
