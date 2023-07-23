package com.zoo.friend.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 18:19
 */
@AllArgsConstructor
@Getter
public enum GPTModel {

    /**
     * gpt-3.5-turbo
     */
    GPT_3_5_TURBO("gpt-3.5-turbo"),

    /**
     * gpt-3.5-turbo-0613
     */
    GPT_3_5_TURBO_0613("gpt-3.5-turbo-0613"),
    /**
     * gpt-3.5-turbo-16k
     */
    GPT_3_5_TURBO_16K("gpt-3.5-turbo-16k"),
    /**
     * gpt-3.5-turbo-16k-0613
     */
    GPT_3_5_TURBO_16K_0613("gpt-3.5-turbo-16k-0613"),
    /**
     * GPT4.0
     */
    GPT_4("gpt-4"),

    /**
     * GPT4.0
     */
    GPT_4_32K("gpt-4-32k"),

    /**
     * gpt-4-0613，
     */
    GPT_4_0613("gpt-4-0613"),
    /**
     * gpt-4-0613，
     */
    GPT_4_32K_0613("gpt-4-32k-0613"),
    ;
    private final String name;
}
