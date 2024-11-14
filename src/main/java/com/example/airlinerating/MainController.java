package com.example.airlinerating;

import com.example.airlinerating.DTO.UserDTO;
import com.example.airlinerating.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class MainController {
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home() {
        return "Welcome";
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @ResponseBody
    @RequestMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }
}
