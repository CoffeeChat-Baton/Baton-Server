package sideproject.coffeechat.domain.member.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Member {

    private Long educationId;

    private String educationName;

    private Long majorId;

    private String majorName;

    private Boolean isEnrolled;

}
