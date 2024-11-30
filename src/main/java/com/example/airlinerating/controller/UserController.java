package com.example.airlinerating.controller;

import com.example.airlinerating.Entity.Game;
import com.example.airlinerating.Entity.User;
import com.example.airlinerating.repository.UserRepository;
import com.example.airlinerating.service.impl.GameServiceImpl;
import com.example.airlinerating.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameServiceImpl gameService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam String search) {
        return userRepository.findByNameContainingIgnoreCase(search);
    }

    @PostMapping("/addGame")
    public ResponseEntity<String> addGame(@RequestParam("email[]") List<String> emails,
                                          @RequestParam("rank[]") List<Integer> ranks,
                                          @RequestParam("rebuyin[]") List<Integer> rebuyins,
                                          @RequestParam("gameDate") String gameDate,
                                          HttpServletResponse response) throws IOException {
        List<Game> games = new ArrayList<>();
        String gameId = UUID.randomUUID().toString();
        for (int i = 0; i < emails.size(); i++) {
            String email = emails.get(i);
            Integer userRank = ranks.get(i);
            Integer rebuyin = rebuyins.get(i);

            Game game = new Game(gameId, email, userRank, rebuyin, gameDate);
            games.add(game);
        }
        System.out.println(games);

        gameService.addGameAndUpdateRatings(games);
        response.sendRedirect("/");
        return ResponseEntity.ok("Form submitted successfully");  // 이 줄은 사실 실행되지 않음
    }

    @PostMapping("/updateUser")
    public ResponseEntity<String> updateUser(
            OAuth2AuthenticationToken authentication, @RequestParam String nickname,
            @RequestParam String name, HttpServletResponse response) throws IOException {

        // Authentication에서 UserDetails를 가져오기
        DefaultOidcUser principal = (DefaultOidcUser) authentication.getPrincipal();

        // DefaultOidcUser에서 이메일 가져오기
        // UserDetails에서 이메일을 가져오기
        String email = principal.getEmail();

        userService.updateUserDetails(email, name, nickname);
        response.sendRedirect("/");
        return ResponseEntity.ok("Form submitted successfully");  // 이 줄은 사실 실행되지 않음
    }
}
