package sideproject.coffeechat.domain.baton.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioBatonRegisterRequest {

    @NotNull
    @Future
    private LocalDate deadline;

    @NotNull
    private String questionContent;

}
