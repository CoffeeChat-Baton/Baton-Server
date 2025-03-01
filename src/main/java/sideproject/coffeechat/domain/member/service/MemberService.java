package sideproject.coffeechat.domain.member.service;

import static sideproject.coffeechat.global.response.code.ErrorCode.MEMBER_NOT_FOUND;

import jakarta.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import sideproject.coffeechat.domain.member.dto.request.LoginRequest;
import sideproject.coffeechat.domain.member.dto.response.LoginResponse;
import sideproject.coffeechat.domain.member.entity.GeneralMember;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.member.entity.Role;
import sideproject.coffeechat.domain.member.entity.SocialType;
import sideproject.coffeechat.domain.member.repository.MemberRepository;
import sideproject.coffeechat.global.response.code.ErrorCode;
import sideproject.coffeechat.global.response.exception.MemberException;
import sideproject.coffeechat.global.security.jwt.JwtTokenUtil;
import sideproject.coffeechat.global.security.jwt.TokenInfo;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final SocialServiceManager socialServiceManager;
    private final JwtTokenUtil jwtTokenUtil;

    public LoginResponse socialLogin(LoginRequest request) {
        SocialType socialType = request.getSocialType();
        String username = socialServiceManager.login(socialType, request.getToken());

        Member member = getOrRegisterMember(username, socialType);
        TokenInfo tokenInfo = generateToken(member);

        if (member.getNickname() == null) {
            return new LoginResponse(true, tokenInfo);
        }
        return new LoginResponse(false, tokenInfo);
    }

    private TokenInfo generateToken(Member member) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                member.getUsername(), null, member.getAuthorities());
        TokenInfo tokenInfo = jwtTokenUtil.generateAccessToken(authentication);

        member.updateRefreshToken(tokenInfo.getRefreshToken());

        return tokenInfo;
    }

    private Member getOrRegisterMember(String username, SocialType socialType) {
        return memberRepository.findWithRolesByUsername(username)
                .orElseGet(() ->
                        memberRepository.save(
                                new GeneralMember(socialType, username, new HashSet<>(Set.of(Role.ROLE_USER)))
                        ));
    }

    // TODO : DEV 사용자 로그인
    public LoginResponse devLogin(LoginRequest request) {
        SocialType socialType = request.getSocialType();
        if (socialType != SocialType.DEV) {
            throw new MemberException(ErrorCode.SOCIAL_TYPE_ERROR, "Social type should be 'DEV' in dev-login request.");
        }
        String username = request.getToken();

        Member member = getOrRegisterMember(username, socialType);
        TokenInfo tokenInfo = generateDevToken(member);

        if (member.getNickname() == null) {
            return new LoginResponse(true, tokenInfo);
        }
        return new LoginResponse(false, tokenInfo);
    }

    private TokenInfo generateDevToken(Member member) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                member.getUsername(), null, member.getAuthorities());
        TokenInfo tokenInfo = jwtTokenUtil.generateDevToken(authentication);

        member.updateRefreshToken(tokenInfo.getRefreshToken());

        return tokenInfo;
    }

    public Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));
    }

}
