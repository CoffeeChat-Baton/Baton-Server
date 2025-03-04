package sideproject.coffeechat.domain.mentor.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sideproject.coffeechat.domain.mentor.dto.request.MentorRegisterRequest;
import sideproject.coffeechat.domain.mentor.service.MentorService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mentor")
public class MentorController {

    private final MentorService mentorService;

    // TODO: 임시 멘토 생성 API
    @PostMapping("/create")
    public Response<Void> create(@RequestParam String companyName, Authentication authentication) {
        mentorService.create(companyName, authentication.getName());
        return Response.success();
    }
}
