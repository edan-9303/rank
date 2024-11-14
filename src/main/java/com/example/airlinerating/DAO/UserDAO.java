package com.example.airlinerating.DAO;

import com.example.airlinerating.DTO.UserDTO;

import java.util.List;

public interface UserDAO {
    List<UserDTO> getUsers();
}
