package sideproject.coffeechat.domain.member.entity;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import sideproject.coffeechat.domain.member.service.KakaoService;
import sideproject.coffeechat.domain.member.service.SocialService;

@RequiredArgsConstructor
public enum SocialType {

    KAKAO(KakaoService.class),
    DEV(null);

    private final Class<? extends SocialService> serviceClass;

    public static SocialType fromService(SocialService service) {
        return Arrays.stream(values())
                .filter(type -> type.serviceClass.isInstance(service))
                .findFirst()
                .orElse(null);
    }
}
