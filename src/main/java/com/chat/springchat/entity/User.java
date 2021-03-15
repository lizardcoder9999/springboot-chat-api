package com.chat.springchat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name="Users")
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String profilePhoto;

    public User(String userName, String password, String email, String profilePhoto) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.profilePhoto = profilePhoto;
    }
}
