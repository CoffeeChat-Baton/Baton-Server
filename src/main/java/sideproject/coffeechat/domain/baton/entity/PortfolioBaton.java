package sideproject.coffeechat.domain.baton.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@DiscriminatorValue("PORTFOLIO")
public class PortfolioBaton extends Baton {

    private LocalDate deadline;

    private String questionContent;

}
