# spring-chatgpt（メモ）

### Java,Mavenのインストール手順
（書く予定）
### curl 成功例
・直接Azure側のAPIを呼び出すコマンド<br>
curl -X POST https://openai-ind-chatbot.openai.azure.com/openai/deployments/ind-chatbot/chat/completions?api-version=2023-03-15-preview -H "Content-Type:application/json" -H "api-key: 0c4460ec3e4b4382863c41dea7cb4485" -d "{\"messages\":[{\"role\":\"user\", \"content\":\"ジョジョ風でなにか言ってください\"}], \"max_tokens\":"300"}"

・今回作成したControllerからの呼び出し<br>
curl -X POST http://localhost:8080/AzureOpenAI/chat -H "Content-Type:application/json" -d "{\"messages\":[{\"role\":\"user\", \"content\":\"who are you\"}], \"max_tokens\":"300"}"
