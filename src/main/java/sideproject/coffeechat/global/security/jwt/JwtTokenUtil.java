package sideproject.coffeechat.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import sideproject.coffeechat.global.security.MemberDetailsService;

@Slf4j
@Component
public class JwtTokenUtil {

    private static final int DEV_ACCESS_TOKEN_DURATION = 100;
    private static final int ACCESS_TOKEN_DURATION = 1;
    private static final int REFRESH_TOKEN_DURATION = 30;

    private final Key key;
    private final MemberDetailsService userDetailsService;

    public JwtTokenUtil(@Value("${jwt.secret}") String secretKey, MemberDetailsService userDetailsService) {
        byte[] keyBytes = secretKey.getBytes();
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.userDetailsService = userDetailsService;
    }

    public Authentication getAuthentication(String accessToken) {
        Claims claims = getClaims(accessToken);
        String username = claims.getSubject();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    private Claims getClaims(String accessToken) {
        return Jwts.parser()
                .verifyWith((SecretKey) key)
                .build()
                .parseSignedClaims(accessToken)
                .getPayload();
    }

    public TokenInfo generateAccessToken(Authentication authentication) {
        String accessToken = generateAccessToken(authentication, ACCESS_TOKEN_DURATION);
        String refreshToken = generateRefreshToken();
        return new TokenInfo("Bearer", accessToken, refreshToken);
    }

    private String generateAccessToken(Authentication authentication, int duration) {
        LocalDateTime now = LocalDateTime.now();
        Date expirationDate = Date.from(now.plusDays(duration)
                .atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .subject(authentication.getName())
                .expiration(expirationDate)
                .signWith(key)
                .compact();
    }

    private String generateRefreshToken() {
        LocalDateTime now = LocalDateTime.now();
        Date expirationDate = Date.from(now.plusDays(REFRESH_TOKEN_DURATION)
                .atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .subject(UUID.randomUUID().toString())
                .expiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) key)
                    .build()
                    .parseSignedClaims(token);

            return true;
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token");
        } catch (MalformedJwtException e) {
            log.error("Malformed JWT token");
        } catch (SignatureException e) {
            log.error("JWT signature doesn't match");
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty");
        }
        return false;
    }

    // TODO : DEV 토큰 생성
    public TokenInfo generateDevToken(Authentication authentication) {
        String accessToken = generateAccessToken(authentication, DEV_ACCESS_TOKEN_DURATION);
        String refreshToken = generateRefreshToken();
        return new TokenInfo("Bearer", accessToken, refreshToken);
    }

}
