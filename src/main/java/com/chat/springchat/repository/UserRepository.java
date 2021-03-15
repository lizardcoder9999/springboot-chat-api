package com.chat.springchat.repository;

import com.chat.springchat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
    Optional<User> findUserByEmail(String email);
}
