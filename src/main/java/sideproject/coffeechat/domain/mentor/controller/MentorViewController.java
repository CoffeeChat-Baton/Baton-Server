package sideproject.coffeechat.domain.mentor.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sideproject.coffeechat.domain.mentor.dto.response.CompactMentorResponse;
import sideproject.coffeechat.domain.mentor.dto.response.MentorResponse;
import sideproject.coffeechat.domain.mentor.service.MentorViewService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mentor")
public class MentorViewController {

    private final MentorViewService mentorViewService;

    @GetMapping("/{mentorId}")
    public Response<MentorResponse> getMentor(@PathVariable Long mentorId) {
        return Response.success(mentorViewService.getMentor(mentorId));
    }

}
