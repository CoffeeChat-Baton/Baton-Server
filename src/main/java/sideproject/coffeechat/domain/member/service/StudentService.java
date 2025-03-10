package sideproject.coffeechat.domain.member.service;

import static sideproject.coffeechat.global.response.code.ErrorCode.EDUCATION_NOT_FOUND;
import static sideproject.coffeechat.global.response.code.ErrorCode.STUDENT_REQUEST_ERROR;
import static sideproject.coffeechat.global.response.code.ErrorCode.SUB_JOB_NOT_FOUND;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sideproject.coffeechat.domain.member.dto.converter.EducationConverter;
import sideproject.coffeechat.domain.member.dto.request.StudentJoinRequest;
import sideproject.coffeechat.domain.member.dto.response.EducationResponse;
import sideproject.coffeechat.domain.member.dto.response.MajorResponse;
import sideproject.coffeechat.domain.member.entity.Education;
import sideproject.coffeechat.domain.member.entity.Major;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.member.repository.EducationRepository;
import sideproject.coffeechat.domain.member.repository.MajorRepository;
import sideproject.coffeechat.domain.member.repository.StudentMapper;
import sideproject.coffeechat.global.response.exception.MemberException;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private static final String ETC = "기타";

    private final MemberService memberService;
    private final EducationRepository educationRepository;
    private final MajorRepository majorRepository;
    private final StudentMapper studentMapper;

    public void join(StudentJoinRequest request, MultipartFile profileImage, String username) {
        Member member = memberService.getMemberByUsername(username);
        saveStudent(request, member);
        memberService.uploadProfileImage(member, profileImage);
    }

    private void saveStudent(StudentJoinRequest request, Member member) {
        Map<String, String> educationalNames = validateAndGetCustomEducationalNames(
                request.getEducationId(), request.getCustomEducationName(),
                request.getMajorId(), request.getCustomMajorName()
        );
        studentMapper.joinWorker(
                member.getId(),
                request.getNickname(),
                request.getEducationId(), educationalNames.get("educationName"),
                request.getMajorId(), educationalNames.get("majorName"),
                request.getIsEnrolled(),
                request.getEmail()
        );
    }

    public Map<String, String> validateAndGetCustomEducationalNames(Long educationId, String customEducationName,
                                                                    Long majorId, String customMajorName) {
        Education education = educationRepository.findById(educationId)
                .orElseThrow(() -> new MemberException(EDUCATION_NOT_FOUND));
        Major major = majorRepository.findById(majorId)
                .orElseThrow(() -> new MemberException(SUB_JOB_NOT_FOUND));

        if (!major.getEducation().getId().equals(educationId)) {
            throw new MemberException(STUDENT_REQUEST_ERROR, "This Major does not belong to this Education");
        }

        return validateCustomEducationalNames(education, customEducationName, major, customMajorName);
    }

    private static Map<String, String> validateCustomEducationalNames(Education education, String customEducationName,
                                                                      Major major, String customMajorName) {
        boolean isEducationEtc = education.getEducationName().equals(ETC);
        boolean isMajorEtc = major.getMajorName().equals(ETC);

        if (isEducationEtc && (customEducationName == null)) {
            throw new MemberException(STUDENT_REQUEST_ERROR, "CustomEducationName is required");
        }
        if (isMajorEtc && (customMajorName == null)) {
            throw new MemberException(STUDENT_REQUEST_ERROR, "CustomMajorName is required");
        }

        return Map.of(
                "educationName", isEducationEtc ? customEducationName : education.getEducationName(),
                "majorName", isMajorEtc ? customMajorName : major.getMajorName()
        );
    }

    @Transactional(readOnly = true)
    public List<EducationResponse> getEducations() {
        List<Education> educations = educationRepository.findAll(Sort.by(Direction.ASC, "id"));
        return EducationConverter.toEducationResponseList(educations);
    }

    @Transactional(readOnly = true)
    public List<MajorResponse> getMajorsByEducationId(Long educationId) {
        List<Major> majors = majorRepository.findByEducationIdOrderByIdAsc(educationId);
        return EducationConverter.toMajorResponseList(majors);
    }

}
