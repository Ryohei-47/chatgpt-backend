package com.example.demo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CompletionsParameter {

    @JsonProperty("prompt")
    private List<String> prompt;

    @JsonProperty("max_tokens")
    private int maxTokens;

    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("top_p")
    private double topP;

    @JsonProperty("logit_bias")
    private Map<String, Integer> logitBias;

    private String user;

    private Integer n;

    private Boolean stream;

    private Integer logrprobs;

    private List<String> stop;

    @JsonProperty("presence_penalty")
    private int presencePenalty;

    @JsonProperty("frequency_penalty")
    private int frequencyPenalty;

    private Integer bestOf;
}
