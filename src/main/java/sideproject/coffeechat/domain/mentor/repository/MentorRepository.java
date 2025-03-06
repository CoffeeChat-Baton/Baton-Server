package sideproject.coffeechat.domain.mentor.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sideproject.coffeechat.domain.mentor.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    Optional<Mentor> findByWorkerId(Long workerId);

    @EntityGraph(attributePaths = {"availableSchedules"})
    Optional<Mentor> findWithAvailableSchedulesById(Long mentorId);

}
