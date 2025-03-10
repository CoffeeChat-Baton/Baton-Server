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
import sideproject.coffeechat.domain.member.dto.request.StudentJoinRequest;
import sideproject.coffeechat.domain.member.dto.response.EducationResponse;
import sideproject.coffeechat.domain.member.dto.response.MajorResponse;
import sideproject.coffeechat.domain.member.service.StudentService;
import sideproject.coffeechat.global.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/join")
    public Response<Void> joinStudent(
            @RequestPart @Valid StudentJoinRequest request,
            @RequestPart(required = false) MultipartFile profileImage,
            Authentication authentication
    ) {
        studentService.join(request, profileImage, authentication.getName());
        return Response.success();
    }

    @GetMapping("/education-list")
    public Response<List<EducationResponse>> getEducations() {
        return Response.success(studentService.getEducations());
    }

    @GetMapping("/major-list/{educationId}")
    public Response<List<MajorResponse>> getSubJobsByJobId(@PathVariable Long educationId) {
        return Response.success(studentService.getMajorsByEducationId(educationId));
    }
    
}
