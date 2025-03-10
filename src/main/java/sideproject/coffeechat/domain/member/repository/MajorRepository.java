package sideproject.coffeechat.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sideproject.coffeechat.domain.member.entity.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
}
