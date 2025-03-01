package sideproject.coffeechat.domain.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sideproject.coffeechat.domain.member.dto.request.LoginRequest;
import sideproject.coffeechat.domain.member.dto.response.LoginResponse;
import sideproject.coffeechat.domain.member.service.MemberService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    // TODO : Login api only development usage
    @PostMapping("/login/dev")
    public Response<LoginResponse> devLogin(@RequestBody @Valid LoginRequest request) {
        return Response.success(memberService.devLogin(request));
    }

}
