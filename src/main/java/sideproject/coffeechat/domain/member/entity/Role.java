package sideproject.coffeechat.domain.member.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role implements GrantedAuthority {

    ROLE_USER,
    ROLE_MENTOR;

    @Override
    public String getAuthority() {
        return name();
    }

    public static Set<Role> fromString(String roles) throws IllegalArgumentException {
        if (roles == null || roles.isBlank()) {
            throw new IllegalArgumentException("Role is Empty.");
        }
        return Arrays.stream(roles.split(","))
                .map(String::trim)
                .map(Role::valueOf)
                .collect(Collectors.toSet());
    }
}
