package sideproject.coffeechat.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sideproject.coffeechat.domain.member.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
