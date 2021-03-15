package com.chat.springchat.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Messages")
public class Message implements Serializable {
    public Message() {
    }

    @Id
    @SequenceGenerator(name = "message_sequence", sequenceName = "message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
    private Long Id;
    private String sentBy;
    private String message;

    private Long GroupChatId;

    public Message(Long id, String sentBy, String message, Long groupChatId) {
        Id = id;
        this.sentBy = sentBy;
        this.message = message;
        this.GroupChatId = groupChatId;
    }

    public Message(String sentBy, String message, Long groupChatId) {
        this.sentBy = sentBy;
        this.message = message;
        this.GroupChatId = groupChatId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getGroupChatId() {
        return GroupChatId;
    }

    public void setGroupChatId(Long groupChatId) {
        GroupChatId = groupChatId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Id=" + Id +
                ", sentBy='" + sentBy + '\'' +
                ", message='" + message + '\'' +
                ", GroupChatId=" + GroupChatId +
                '}';
    }
}