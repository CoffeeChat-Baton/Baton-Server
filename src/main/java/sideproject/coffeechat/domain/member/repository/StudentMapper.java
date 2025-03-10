package sideproject.coffeechat.domain.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {

    @Update("""
        UPDATE members
        SET member_type = 'STUDENT',
            nickname = #{nickname},
            education_id = #{educationId}, education_name = #{educationName},
            major_id = #{majorId}, major_name = #{majorName},
            is_enrolled = #{isEnrolled},
            email = #{email}
        WHERE members.id = #{memberId};
    """)
    void joinWorker(Long memberId,
                    String nickname,
                    Long educationId, String educationName,
                    Long majorId, String majorName,
                    boolean isEnrolled,
                    String email);

}
