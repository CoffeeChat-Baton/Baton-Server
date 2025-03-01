package sideproject.coffeechat.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sideproject.coffeechat.global.security.jwt.TokenInfo;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private boolean isNewMember;

    private TokenInfo tokenInfo;

}
