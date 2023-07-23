package com.zoo.friend;

import com.zoo.friend.listener.LogEventSourceListener;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 16:47
 */
public class OpenAIClientTest {
    public static void main(String[] args) {
        OpenAIClient client = OpenAIClient.Party()
                .apikey("")
                .partyRun();
        LogEventSourceListener logEventSourceListener = new LogEventSourceListener();

    }
}
