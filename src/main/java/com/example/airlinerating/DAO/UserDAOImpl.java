package com.example.airlinerating.DAO;

import com.example.airlinerating.DTO.UserDTO;
import com.example.airlinerating.Entity.User;
import com.example.airlinerating.Mapper.UserMapper;
import com.example.airlinerating.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDAOImpl implements UserDAO {
    UserRepository userRepository;
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    @Autowired
    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(INSTANCE::userToUserDTO)
                .collect(Collectors.toList());
    }
}
