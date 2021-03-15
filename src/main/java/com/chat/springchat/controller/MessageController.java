package com.chat.springchat.controller;

import com.chat.springchat.entity.Message;
import com.chat.springchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping("/create")
    public void createMessage(@RequestBody Message message, @RequestParam Long groupChatId){
        messageService.AddMessage(message,groupChatId);
    }

    @GetMapping("/get")
    public List<Message> getMessagesForChat(@RequestParam Long Id){
        return messageService.getAllMessagesForChat(Id);
    }

}
