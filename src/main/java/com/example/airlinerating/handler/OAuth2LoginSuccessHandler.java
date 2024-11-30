package com.example.airlinerating.handler;

import com.example.airlinerating.Entity.User;
import com.example.airlinerating.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        // OAuth2 사용자 정보 가져오기
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();

        // 사용자 정보를 추출
        String email = oauth2User.getAttribute("email");
        String name = oauth2User.getAttribute("name");
        String profilePictureUrl = oauth2User.getAttribute("picture");

        // 사용자 정보 DB에 저장
        Optional<User> user = userRepository.findByEmail(email);
        User newUser = new User();
        // 사용자 정보가 없으면 새로 저장
        if (user.isEmpty()) {
            newUser = new User(email, name, "", profilePictureUrl, -1, "");
            // rank
            // mmr 기본은 -1 = unranked
            // mmr 처음 머니인 = 1200점 시작
            // mmr 처음 노머니인 = 1000점 시작
            userRepository.save(newUser);
        }


        // 로그인 성공 후 URL로 리다이렉트
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
