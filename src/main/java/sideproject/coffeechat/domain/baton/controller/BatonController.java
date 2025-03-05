package sideproject.coffeechat.domain.baton.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sideproject.coffeechat.domain.baton.dto.BatonRegisterRequest;
import sideproject.coffeechat.domain.baton.service.BatonService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/baton")
public class BatonController {

    private final BatonService batonService;

    @PostMapping("/{mentorId}")
    public Response<Void> registerBaton(
            @PathVariable Long mentorId,
            @RequestPart @Valid BatonRegisterRequest request,
            @RequestPart(required = false) MultipartFile attachment,
            Authentication authentication
    ) {
        batonService.register(mentorId, request, attachment, authentication.getName());
        return Response.success();
    }

}
