package com.chat.springchat.controller;

import com.chat.springchat.entity.GroupChat;
import com.chat.springchat.service.GroupChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groupchat")
public class GroupChatController {

    private final GroupChatService groupChatService;

    @Autowired
    public GroupChatController(GroupChatService groupChatService){
        this.groupChatService = groupChatService;
    }

    @GetMapping("/all")
    public List<GroupChat> getAll(){
        return groupChatService.getAllChats();
    }

    @PostMapping("/create")
    public void createChat(@RequestParam String groupChatName){
        groupChatService.AddGroupChat(groupChatName);
    }

}
