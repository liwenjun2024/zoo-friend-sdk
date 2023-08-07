# zoo-friend-sdk

目前加入了ChatGPT（支持持流式），以后会加入MJ  SD等。

### 使用方式
```
ChatGPTMessage message = ChatGPTMessage.Party()
                .setRole(Role.USER).setContent("我今天没有吃水果，你可以给我推荐一些吗").partyRun();
                
ChatGPTCompletion completion = ChatGPTCompletion.builder().messages(Arrays.asList(message)).build();

OpenAIClient client = OpenAIClient.Party()
                .apikey("sk-***")
                .partyRun();

LogEventSourceListener eventSourceListener = new LogEventSourceListener();
client.streamCompletions(completion,eventSourceListener);
```
