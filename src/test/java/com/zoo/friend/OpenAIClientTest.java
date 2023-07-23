package com.zoo.friend;

import com.zoo.friend.constant.Role;
import com.zoo.friend.entity.AI.chat.ChatGPTCompletion;
import com.zoo.friend.entity.AI.chat.ChatGPTMessage;
import com.zoo.friend.listener.LogEventSourceListener;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 16:47
 */
public class OpenAIClientTest {
    public static void main(String[] args) {
        ChatGPTMessage message = ChatGPTMessage.Party()
                .setRole(Role.USER).setContent("家人们，无语死了").partyRun();
        ChatGPTCompletion completion = ChatGPTCompletion.builder().messages(message).build();
        OpenAIClient client = OpenAIClient.Party()
                .apikey("")
                .partyRun();
        LogEventSourceListener eventSourceListener = new LogEventSourceListener();
        client.streamCompletions(completion,eventSourceListener);

    }
}
