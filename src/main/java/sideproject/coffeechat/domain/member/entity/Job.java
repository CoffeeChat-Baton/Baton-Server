package sideproject.coffeechat.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Job {

    @Id
    private Long id;

    // 직무명 (ex. 경영·비즈니스, 디자인, 기타)
    @Column(nullable = false, unique = true)
    private String jobName;

}
