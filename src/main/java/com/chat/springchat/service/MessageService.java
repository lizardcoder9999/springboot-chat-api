package com.chat.springchat.service;

import com.chat.springchat.entity.Message;
import com.chat.springchat.repository.GroupChatRepository;
import com.chat.springchat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final GroupChatRepository groupChatRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository,GroupChatRepository groupChatRepository){
        this.messageRepository = messageRepository;
        this.groupChatRepository = groupChatRepository;
    }

    public void AddMessage(Message newMessage,Long groupChatId){
        Message message = new Message();
        message.setSentBy(newMessage.getSentBy());
        message.setMessage(newMessage.getMessage());
        message.setGroupChatId(groupChatId);
        messageRepository.save(message);
    }

    public List<Message> getAllMessagesForChat(Long Id){
        return messageRepository.getMessagesByGroupChatId(Id);
    }



}
