package com.chat.springchat.service;

import com.chat.springchat.entity.User;
import com.chat.springchat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public void registerNewUser(User user) throws Exception{
        try{
            Optional<User> existingUser = userRepository.findUserByEmail(user.getEmail());
            if(existingUser.isPresent()){
                throw new Exception("A User is already registered with this email address");
            }
        }catch (Exception e){
            throw new Exception("An error has occurred on the server");
        }
        User registeringUser = new User();
        registeringUser.setUserName(user.getUserName());
        registeringUser.setEmail(user.getEmail());
        registeringUser.setProfilePhoto(user.getProfilePhoto());
        registeringUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(registeringUser);
    }
}
