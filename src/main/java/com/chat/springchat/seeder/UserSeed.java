package com.chat.springchat.seeder;

import com.chat.springchat.entity.User;
import com.chat.springchat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class UserSeed {

    private final UserRepository userRepository;

    @Autowired
    public UserSeed(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initUsers(){
             User testUser = new User("username","password","user@email.com","randomPhoto.url/photo.png");
             userRepository.save(testUser);

    }
}
