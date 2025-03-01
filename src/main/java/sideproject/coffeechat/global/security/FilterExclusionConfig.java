package sideproject.coffeechat.global.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sideproject.coffeechat.global.security.jwt.JwtTokenFilter;

/**
 * "@Component" 스프링 시큐리티 필터 서블릿 컨테이너 자동 등록 방지
 */
@Configuration
public class FilterExclusionConfig {

    @Bean
    public FilterRegistrationBean<JwtTokenFilter> jwtTokenFilterRegistration(JwtTokenFilter filter) {
        FilterRegistrationBean<JwtTokenFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }

}
