package sideproject.coffeechat.domain.member.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sideproject.coffeechat.domain.member.entity.SocialType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotNull
    private SocialType socialType;

    @NotNull
    private String token;

}
