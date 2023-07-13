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
public class AzureOpenAIService {

    Logger logger = LoggerFactory.getLogger(AzureOpenAIService.class);

    @Autowired
    private AzureOpenAIConfig azureOpenAIConfig;

    //チャット入力API
    public String Completions(CompletionsParameter parameter){

        if(logger.isDebugEnabled()){
            logger.info(azureOpenAIConfig.getChatCompletionsUrl());
            logger.info(azureOpenAIConfig.getChatCompletionsKey());
            logger.info(toJson(parameter));
        }

        //ヘッダ作成
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AzureOpenAIConfig.APIKEY, azureOpenAIConfig.getChatCompletionsKey());
        
        //エンティティの作成
        HttpEntity<CompletionsParameter> entity = new HttpEntity<CompletionsParameter>(parameter, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(azureOpenAIConfig.getChatCompletionsUrl(), HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    //チャット入力API
    public String ChatCompletions(ChatCompletionsParameter parameter){

        if(logger.isDebugEnabled()){
            logger.info(azureOpenAIConfig.getChatCompletionsUrl());
            logger.info(azureOpenAIConfig.getChatCompletionsKey());
            logger.info(toJson(parameter));
        }

        //ヘッダ作成
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AzureOpenAIConfig.APIKEY, azureOpenAIConfig.getChatCompletionsKey());
        
        //エンティティの作成
        HttpEntity<ChatCompletionsParameter> entity = new HttpEntity<ChatCompletionsParameter>(parameter, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(azureOpenAIConfig.getChatCompletionsUrl(), HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    //Jsonの型へ変換
    private String toJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.writeValueAsString(obj);
        }catch(JsonProcessingException e){
            return "error";
        }
    }
}
