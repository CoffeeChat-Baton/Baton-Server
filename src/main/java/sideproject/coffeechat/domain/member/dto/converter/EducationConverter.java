package sideproject.coffeechat.domain.member.dto.converter;

import java.util.List;
import sideproject.coffeechat.domain.member.dto.response.EducationResponse;
import sideproject.coffeechat.domain.member.dto.response.MajorResponse;
import sideproject.coffeechat.domain.member.entity.Education;
import sideproject.coffeechat.domain.member.entity.Major;

public class EducationConverter {

    public static List<EducationResponse> toEducationResponseList(List<Education> educations) {
        return educations.stream()
                .map(education -> new EducationResponse(education.getId(), education.getEducationName()))
                .toList();
    }

    public static List<MajorResponse> toMajorResponseList(List<Major> majors) {
        return majors.stream()
                .map(major ->
                        new MajorResponse(major.getEducation().getId(), major.getId(), major.getMajorName()))
                .toList();
    }

}
