package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Service
public class ChatService {

    @Autowired
    private ChatgptConfig chatgptConfig;

    public String chatCompletions(ChatParameter parameter){

        //ヘッダ作成
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(ChatgptConfig.APIKEY, chatgptConfig.getChatCompletionsKey());
        
        //エンティティの作成
        HttpEntity<ChatParameter> request = new HttpEntity<ChatParameter>(parameter, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(chatgptConfig.getChatCompletionsUrl(), HttpMethod.POST, request, String.class);

        return response.getBody();
    }
}
