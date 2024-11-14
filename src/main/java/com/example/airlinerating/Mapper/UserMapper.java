package com.example.airlinerating.Mapper;

import com.example.airlinerating.DTO.UserDTO;
import com.example.airlinerating.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // @Mapper 어노테이션과 Spring Bean으로 등록
public interface UserMapper {
    @Mapping(source = "email", target = "email")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "nickName", target = "nickName")
    @Mapping(source = "profilePictureUrl", target = "profilePictureUrl")
    @Mapping(source = "rating", target = "rating")
    UserDTO userToUserDTO(User user);
}