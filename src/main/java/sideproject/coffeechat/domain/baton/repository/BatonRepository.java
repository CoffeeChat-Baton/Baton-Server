package sideproject.coffeechat.domain.baton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sideproject.coffeechat.domain.baton.entity.Baton;

@Repository
public interface BatonRepository extends JpaRepository<Baton, Long> {
}
