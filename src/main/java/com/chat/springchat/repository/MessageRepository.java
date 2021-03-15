package com.chat.springchat.repository;

import com.chat.springchat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    @Query(value = "SELECT * FROM messages WHERE group_chat_id = ?1", nativeQuery = true)
    List<Message> getMessagesByGroupChatId(Long Id);
}
