package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private ChatService chatService;

    //チャットAPI
    @RequestMapping(value = "/chat",method = RequestMethod.POST)
    public String chat(ChatParameter parameter){
        return chatService.chatCompletions(parameter);
    }
}
