package com.zoo.friend.entity.common.openai;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zoo.friend.entity.AI.chat.ChatGPTMessage;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Choice implements Serializable {
    private long index;
    /**
     * 请求参数stream为true返回是delta
     */
    @JsonProperty("delta")
    private ChatGPTMessage delta;
    /**
     * 请求参数stream为false返回是message
     */
    @JsonProperty("message")
    private ChatGPTMessage message;
    @JsonProperty("finish_reason")
    private String finishReason;
}