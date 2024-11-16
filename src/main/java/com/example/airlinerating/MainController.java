package com.example.airlinerating;

import com.example.airlinerating.DTO.UserDTO;
import com.example.airlinerating.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OAuth2User user, Model model) {
        if (user == null) {
            return "login";
        }
        List<UserDTO> users = userService.getUsers();
        model.addAttribute("users", users);

        return "index";
    }

    @RequestMapping("/dashboard")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
