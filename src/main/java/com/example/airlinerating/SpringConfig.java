package com.example.airlinerating;

import com.example.airlinerating.handler.OAuth2LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig {
    private final OAuth2LoginSuccessHandler oauth2LoginSuccessHandler;

    public SpringConfig(OAuth2LoginSuccessHandler oauth2LoginSuccessHandler) {
        this.oauth2LoginSuccessHandler = oauth2LoginSuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/login").permitAll();
                    registry.anyRequest().authenticated();
                })
                .oauth2Login(oauth2 -> oauth2.successHandler(oauth2LoginSuccessHandler))
                .exceptionHandling(exceptions ->
                        exceptions
                                .accessDeniedPage("/access-denied")  // 접근 거부 시 리다이렉트할 페이지 설정
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")  // 로그인 페이지 설정
                        .permitAll()           // 로그인 페이지는 누구나 접근 가능
                )
                .build();
    }
}
