package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ChatgptConfig {

    //APIKEY項目名
    public static String APIKEY = "api-key";

    //入力候補API
    @Value("${azureopenai.completions.url}")
    private String completionsUrl;

    @Value("${azureopenai.completions.key}")
    private String completionslKey;

    //チャットAPI
    @Value("${azureopenai.chatcompletions.url}")
    private String chatCompletionsUrl;

    @Value("${azureopenai.chatcompletions.key}")
    private String chatCompletionsKey;
}
