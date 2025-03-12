package sideproject.coffeechat.domain.baton.dto.mapperdto;

import java.time.LocalDate;
import lombok.Getter;
import sideproject.coffeechat.domain.baton.entity.BatonType;
import sideproject.coffeechat.domain.baton.entity.PortfolioCharge;

@Getter
public class UncompletedPortfolioBatonDTO {

    private Long batonId;

    private BatonType batonType;

    private LocalDate deadline;

    private String questionContent;

    private PortfolioCharge charge;

    private String attachmentUrl;

    private BatonMentorDTO mentor;

}
