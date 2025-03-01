package sideproject.coffeechat.domain.member.service;

import org.springframework.stereotype.Service;

// TODO : 카카오 로그인 구현
@Service
public class KakaoService implements SocialService {
    @Override
    public String login(String token) {
        return "";
    }
}
