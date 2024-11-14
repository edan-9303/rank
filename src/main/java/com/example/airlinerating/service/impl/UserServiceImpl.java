package com.example.airlinerating.service.impl;

import com.example.airlinerating.DAO.UserDAOImpl;
import com.example.airlinerating.DTO.UserDTO;
import com.example.airlinerating.service.UserService;
import com.example.airlinerating.util.Tier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAOImpl userDAO;

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

}
