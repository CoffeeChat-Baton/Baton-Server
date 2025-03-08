package sideproject.coffeechat.domain.home.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sideproject.coffeechat.domain.home.dto.HomeJobResponse;
import sideproject.coffeechat.domain.home.service.HomeService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/home")
public class HomeController {

    private final HomeService homeService;

    /**
     * 홈 화면의 멘토 둘러보기 중 직업 리스트 API
     */
    @GetMapping("/jobs")
    public Response<List<HomeJobResponse>> getJobs() {
        return Response.success(homeService.getJobs());
    }

}
