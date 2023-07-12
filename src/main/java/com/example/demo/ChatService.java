package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Service
public class ChatService {

    Logger logger = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private ChatgptConfig chatgptConfig;

    public String chatCompletions(ChatParameter parameter){

        if(logger.isDebugEnabled()){
            logger.info(chatgptConfig.getChatCompletionsUrl());
            logger.info(chatgptConfig.getChatCompletionsKey());
            logger.info(toJson(parameter));
        }

        //ヘッダ作成
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(ChatgptConfig.APIKEY, chatgptConfig.getChatCompletionsKey());
        
        //エンティティの作成
        HttpEntity<ChatParameter> entity = new HttpEntity<ChatParameter>(parameter, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(chatgptConfig.getChatCompletionsUrl(), HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    private String toJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.writeValueAsString(obj);
        }catch(JsonProcessingException e){
            return "error";
        }
    }
}
