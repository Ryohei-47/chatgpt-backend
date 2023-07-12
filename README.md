# spring-chatgpt
### curl 成功例
curl -X POST https://openai-ind-chatbot.openai.azure.com/openai/deployments/ind-chatbot/chat/completions?api-version=2023-03-15-preview -H "Content-Type:application/json" -H "api-key: 0c4460ec3e4b4382863c41dea7cb4485" -d "{\"messages\":[{\"role\":\"user\", \"content\":\"ジョジョ風でなにか言ってください\"}], \"max_tokens\":"300"}"
