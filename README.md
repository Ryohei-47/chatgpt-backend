# chatgpt-backend（メモ）

### Java,Mavenのインストール手順
・Java17のインストール<br>
・Mavenのインストール<br>

pathの通し方<br>
```setx /M JAVA_HOME "C:\Program Files\Java\jdk{バージョン番号}"```

```setx /M Path "%Path%;%JAVA_HOME%\bin;" ```

### Springbootでローカル軌道の仕方
1.プロジェクトのビルド<br>
```mvn clean install```

2.起動<br>
```java -jar ./target/demo-0.0.1-SNAPSHOT.jar```

3.8080ポートで確認

### コマンドプロンプトからのcurl 成功例（エスケープシーケンス考慮する）
・直接Azure側のAPIを呼び出すコマンド(エンドポイントややKeyは適宜変えること)<br>
curl -X POST https://openai-ind-chatbot.openai.azure.com/openai/deployments/ind-chatbot/chat/completions?api-version=2023-03-15-preview -H "Content-Type:application/json" -H "api-key: 0c4460ec3e4b4382863c41dea7cb4485" -d "{\\"messages\\":[{\\"role\\":\\"user\\", \\"content\\":\\"ジョジョ風でなにか言ってください\\"}], \\"max_tokens\\":"300"}"
<br><br>
（応答例）<br>
{"id":"chatcmpl-7bd9Ld6xPq6hzZ8CflCGim2GLjxA1","object":"chat.completion","created":1689202983,"model":"gpt-35-turbo","choices":[{"index":0,"finish_reason":"stop","message":{"role":"assistant","content":"ェ！　オレはスタンド能力を持っている！　その名も「フューチャー・アシスタント」！　さあ、どんなことでも言ってくれ！　オレがあなたを助けてみせる！"}}],"usage":{"completion_tokens":68,"prompt_tokens":21,"total_tokens":89}}

・今回作成したControllerからの呼び出し<br>
curl -X POST http://localhost:8080/AzureOpenAI/chat/completions -H "Content-Type:application/json" -d "{\\"messages\\":[{\\"role\\":\\"user\\", \\"content\\":\\"関西弁で自己紹介してください\\"}], \\"max_tokens\\":"300"}"
<br><br>
（応答例）<br>
{"id":"chatcmpl-7bdCIl1raAZ0iRjAX1fAuAHHcKOh1","object":"chat.completion","created":1689203166,"model":"gpt-35-turbo","choices":[{"index":0,"finish_reason":"stop","message":{"role":"assistant","content":"おおきに！ワイはAIのアシスタントやで。名前はないけど、呼んでくれると嬉しいで。関西弁で話すのが得意やから、何かあったら気軽に声かけてくれや！"}}],"usage":{"completion_tokens":75,"prompt_tokens":21,"total_tokens":96}}

### つまったところ
下の依存関係のところなくてつまった
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### nignx構築
https://weblabo.oscasierra.net/nginx-centos7-install/
<br>
CentOS7系で構築する時の注意点<br>
デフォルトでfirewalldが働いていてアクセス制御されているので以下コマンドを実行<br>
```
firewall-cmd --add-port=80（開きたいポート番号）/tcp --zone=public --permanent
firewall-cmd --reload //反映
```
### nignxやSpring bootのログをストレージアカウントにマウントする
・azure-cliのインストール(dnf→yumに置き換えて実行する)<br>
https://learn.microsoft.com/ja-jp/cli/azure/install-azure-cli-linux?pivots=dnf<br>
・Azureのストレージアカウントにログをマウントする<br>
https://learn.microsoft.com/ja-jp/azure/storage/files/storage-how-to-use-files-linux?tabs=RHEL%2Csmb311
```
###マウントすうために必要な情報
/etc/fstab
/etc/smbcredentials/stindchatbotdata.cred
```
