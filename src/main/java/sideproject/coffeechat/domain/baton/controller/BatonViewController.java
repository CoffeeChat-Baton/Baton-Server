package sideproject.coffeechat.domain.baton.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sideproject.coffeechat.domain.baton.dto.response.CompactBatonResponse;
import sideproject.coffeechat.domain.baton.entity.BatonType;
import sideproject.coffeechat.domain.baton.service.BatonViewService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/baton")
public class BatonViewController {

    private final BatonViewService batonViewService;

    @GetMapping("/requested")
    public Response<List<CompactBatonResponse>> getRequestedBatons(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(required = false) BatonType batonType,
            Authentication authentication
    ) {
        return Response.success(
                batonViewService.getRequestedBatons(authentication.getName(), page, size, batonType)
        );
    }

    @GetMapping("/pending-approval")
    @PreAuthorize("hasRole('MENTOR')")
    public Response<List<CompactBatonResponse>> getPendingBatons(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(required = false) BatonType batonType,
            Authentication authentication
    ) {
        return Response.success(
                batonViewService.getPendingBatons(authentication.getName(), page, size, batonType)
        );
    }
    
}
