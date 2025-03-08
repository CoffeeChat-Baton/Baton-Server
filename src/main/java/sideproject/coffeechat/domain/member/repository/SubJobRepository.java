package sideproject.coffeechat.domain.member.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sideproject.coffeechat.domain.member.entity.SubJob;

@Repository
public interface SubJobRepository extends JpaRepository<SubJob, Long> {

    List<SubJob> findByJobIdOrderByIdAsc(Long jobId);

}
