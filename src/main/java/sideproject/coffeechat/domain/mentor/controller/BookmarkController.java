package sideproject.coffeechat.domain.mentor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sideproject.coffeechat.domain.mentor.service.BookmarkService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookmark")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("/{mentorId}")
    public Response<Void> toggleBookmark(@PathVariable Long mentorId, Authentication authentication) {
        bookmarkService.toggleBookmark(mentorId, authentication.getName());
        return Response.success();
    }

}
