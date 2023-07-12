package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AzureOpenAI")
public class ChatController {

    @Autowired
    private ChatService chatService;

    // Example
    // @RequestMapping(value = "/hello")
    // public String hello(){
    //     return "hello";
    // }

    //チャットAPI
    @RequestMapping(value = "/chat",method = RequestMethod.POST)
    public String chat(@RequestBody ChatParameter parameter){
        return chatService.chatCompletions(parameter);
    }
}
