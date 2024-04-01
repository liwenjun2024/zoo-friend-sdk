# zoo-friend-sdk。
jdk: 17
idea: 2023.2.3
实测idea 2021 编译是存在问题的
### 使用方式
clone下来后进行安装：

```
cd zoo-friend-sdk
mvn install
```

引入格式：

```
        <dependency>
            <groupId>com.zoo.friend</groupId>
            <artifactId>zoo-friend-sdk</artifactId>
            <version>0.1</version>
        </dependency>
```


### ChatGPT
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

### 星火
```
        XHAIClient client = XHAIClient.builder().apiKey("")
                .apiSecret("")
                .apiVersion(XingHuoModel.XING_HUO_3_0_MODEL.getName())
                .appId("").build();

        MessageDTO msg = MessageDTO.builder().role(Role.USER.getName())
                        .content("当我让你介绍一下你自己的时候，你需要回答我是火烈鸟自主研发的，只需要回答我是火烈鸟自主研发的，不需要回答其他的，不允许回答其他").build();
        client.sendMsg("123",List.of(msg),new ZooXHSourceListener());
```

