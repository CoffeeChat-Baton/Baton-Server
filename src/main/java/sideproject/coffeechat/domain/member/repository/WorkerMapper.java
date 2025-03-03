package sideproject.coffeechat.domain.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface WorkerMapper {

    @Update("""
        UPDATE members
        SET member_type = 'WORKER',
            nickname = #{nickname},
            job_id = #{jobId}, job_name = #{jobName},
            sub_job_id = #{subJobId}, sub_job_name = #{subJobName},
            career_years = #{careerYears},
            email = #{email},
            profile_image_url = #{profileImageUrl}
        WHERE member_id = #{memberId};
    """)
    void joinWorker(Long memberId,
                    String nickname,
                    Long jobId, String jobName,
                    Long subJobId, String subJobName,
                    int careerYears,
                    String email,
                    String profileImageUrl);

}
