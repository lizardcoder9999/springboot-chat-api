package com.chat.springchat.service;

import com.chat.springchat.entity.GroupChat;
import com.chat.springchat.entity.Message;
import com.chat.springchat.repository.GroupChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupChatService {

    public final GroupChatRepository groupChatRepository;

    @Autowired
    public GroupChatService(GroupChatRepository groupChatRepository){
        this.groupChatRepository = groupChatRepository;
    }

    public List<GroupChat> getAllChats(){
        return groupChatRepository.findAll();
    }

    public void AddGroupChat(String groupChatName){
        GroupChat groupChat = new GroupChat();
        groupChat.setName(groupChatName);
        groupChatRepository.save(groupChat);
    }


}
