package com.example.demo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ChatCompletionsParameter {

    @JsonProperty("messages")
    private List<Message> messages;

    @JsonProperty("temperature")
    private double temperature;

    private Integer n;

    private Boolean stream;

    private List<String> stop;

    @JsonProperty("max_tokens")
    private int maxTokens;

    @JsonProperty("presence_penalty")
    private int presencePenalty;

    @JsonProperty("frequency_penalty")
    private int frequencyPenalty;

    @JsonProperty("logit_bias")
    private Map<String, Integer> logitBias;

    private String user;
}
