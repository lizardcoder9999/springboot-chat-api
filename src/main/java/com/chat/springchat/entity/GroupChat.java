package com.chat.springchat.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "GroupChats")
public class GroupChat implements Serializable {
    @Id
    @SequenceGenerator(name = "group_sequence",sequenceName = "group_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "group_sequence")
    private Long Id;
    private String Name;

//    @OneToMany(mappedBy = "groupchat",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Message> Messages = new ArrayList<>();


    public GroupChat(Long id, String name) {
        Id = id;
        Name = name;
    }

    public GroupChat(String name) {
        Name = name;
    }

    public GroupChat() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "GroupChat{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
