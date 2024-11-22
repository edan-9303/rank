package com.example.airlinerating.repository;

import com.example.airlinerating.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // 이메일로 사용자 찾기


    Optional<User> findByEmail(String email);

    List<User> findAll();

    List<User> findAllByOrderByRatingDesc();

    List<User> findByEmailContainingIgnoreCase(String search);

    List<User> findByNameContainingIgnoreCase(String search);

}
