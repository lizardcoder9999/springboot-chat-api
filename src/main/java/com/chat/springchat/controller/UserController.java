package com.chat.springchat.controller;

import com.chat.springchat.entity.AuthRequestDto;
import com.chat.springchat.entity.AuthResponseDto;
import com.chat.springchat.entity.User;
import com.chat.springchat.service.CustomUserDetailsService;
import com.chat.springchat.service.UserService;
import com.chat.springchat.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    @Autowired
    public UserController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public AuthResponseDto generateToken(@RequestBody AuthRequestDto authRequestDto) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));
        } catch (Exception e) {
            throw new Exception("Invalid username or password");
        }
        String token =  jwtUtil.generateToken(authRequestDto.getUsername());
        return new AuthResponseDto(token);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) throws Exception {
        userService.registerNewUser(user);
    }
}
