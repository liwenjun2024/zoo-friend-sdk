package com.zoo.friend.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 0:10
 */
@Getter
@AllArgsConstructor
public enum ChartGPTUrl {
    COMPLETIONS("https://api.openai.com/v1/completions"),
    ;

    private final String url;


}
