package com.zoo.friend;

import com.zoo.friend.constant.Role;
import com.zoo.friend.entity.AI.chat.ChatGPTCompletion;
import com.zoo.friend.entity.AI.chat.ChatGPTMessage;
import com.zoo.friend.listener.LogEventSourceListener;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 16:47
 */
public class OpenAIClientTest {
    public static void main(String[] args) {
        ChatGPTMessage message = ChatGPTMessage.Party()
                .setRole(Role.USER).setContent("我今天没有吃水果，你可以给我推荐一些吗").partyRun();
        ChatGPTCompletion completion = ChatGPTCompletion.builder().messages(Arrays.asList(message)).build();
        OpenAIClient client = OpenAIClient.Party()
                .apikey("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")
                .partyRun();

        LogEventSourceListener eventSourceListener = new LogEventSourceListener();
        client.streamCompletions(completion,eventSourceListener);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            countDownLatch.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
