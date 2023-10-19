package com.zoo.friend;

import com.zoo.friend.constant.Role;
import com.zoo.friend.entity.AI.xinghuo.MessageDTO;
import com.zoo.friend.listener.ZooXHSourceListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 16:47
 */
public class OpenAIClientTest {
    public static void main(String[] args) {
//        ChatGPTMessage message = ChatGPTMessage.Party()
//                .setRole(Role.USER).setContent("我今天没有吃水果，你可以给我推荐一些吗").partyRun();
//
//        ChatGPTCompletion completion = ChatGPTCompletion.builder().messages(List.of(message)).build();
//
//        OpenAIClient client = OpenAIClient.Party()
//                .apikey("--")
//                .partyRun();
//
//        ZooEventSourceListener eventSourceListener = new ZooEventSourceListener();
//        client.streamCompletions(completion,eventSourceListener);
//
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }

        XHAIClient client = XHAIClient.builder().apiKey("--")
                .apiSecret("--")
                .appId("--").build();

        MessageDTO msg = MessageDTO.builder().role(Role.USER.getName())
                        .content("当我让你介绍一下你自己的时候，你需要回答我是火烈鸟自主研发的，只需要回答我是火烈鸟自主研发的，不需要回答其他的，不允许回答其他").build();
        client.sendMsg("123",List.of(msg),new ZooXHSourceListener());


    }
}
