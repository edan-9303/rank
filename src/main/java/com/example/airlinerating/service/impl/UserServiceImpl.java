package com.example.airlinerating.service.impl;

import com.example.airlinerating.DAO.UserDAOImpl;
import com.example.airlinerating.DTO.UserDTO;
import com.example.airlinerating.Entity.User;
import com.example.airlinerating.repository.UserRepository;
import com.example.airlinerating.service.UserService;
import com.example.airlinerating.util.Tier;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAOImpl userDAO;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<UserDTO> getUsers() {
        return userDAO.getUsers().stream()
                .peek(item -> item.setTier(Tier.getRank(item.getRating())))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUserDetails(String userEmail, String userName, String userNickname) {
        // 이메일로 사용자 조회
        Optional<User> userOptional = userRepository.findByEmail(userEmail);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // 새로운 userName과 userNickname을 설정
            user.setName(userName);
            user.setNickName(userNickname);
            // 변경된 사용자 정보 저장
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User with email " + userEmail + " not found");
        }
    }

}
