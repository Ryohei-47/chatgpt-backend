package com.example.demo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class ChatParameter {

    @JsonProperty("prompt")
    private String prompt;

    //private int maxTokens;
    @JsonProperty("temperature")
    private int temperature;

    @JsonProperty("top_p")
    private int top_p;

    @JsonProperty("logit_bias")
    private Map<String, Integer> logitBias;

    @JsonProperty("stop")
    private List<String> stop;

    @JsonProperty("presence_penalty")
    private int presencePenalty;

    @JsonProperty("frequency_penalty")
    private int frequencyPenalty;
}
