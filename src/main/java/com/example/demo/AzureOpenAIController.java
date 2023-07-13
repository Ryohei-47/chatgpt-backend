package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AzureOpenAI")
public class AzureOpenAIController {

    @Autowired
    private AzureOpenAIService azureOpenAIService;

    // Example
    // @RequestMapping(value = "/hello")
    // public String hello(){
    //     return "hello";
    // }

    //入力候補API
    @RequestMapping(value = "/completions",method = RequestMethod.POST)
    public String chat(@RequestBody CompletionsParameter parameter){
        return azureOpenAIService.Completions(parameter);
    }

    //チャットAPI
    @RequestMapping(value = "/chat/completions",method = RequestMethod.POST)
    public String chat(@RequestBody ChatCompletionsParameter parameter){
        return azureOpenAIService.ChatCompletions(parameter);
    }
}
