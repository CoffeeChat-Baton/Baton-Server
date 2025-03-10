package sideproject.coffeechat.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Education {

    @Id
    private Long id;

    // 학력 (ex. MBA, 학사, 기타)
    @Column(nullable = false, unique = true)
    private String educationName;

}
