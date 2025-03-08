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
import sideproject.coffeechat.domain.baton.dto.ChatBatonRegisterRequest;
import sideproject.coffeechat.domain.baton.service.BatonService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/baton")
public class BatonController {

    private final BatonService batonService;

    @PostMapping("/chat/{mentorId}")
    public Response<Void> registerChatBaton(
            @PathVariable Long mentorId,
            @RequestPart @Valid ChatBatonRegisterRequest request,
            @RequestPart(required = false) MultipartFile attachment,
            Authentication authentication
    ) {
        batonService.registerChatBaton(mentorId, request, attachment, authentication.getName());
        return Response.success();
    }

}
