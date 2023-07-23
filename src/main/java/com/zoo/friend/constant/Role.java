package com.zoo.friend.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 18:03
 */
@Getter
@AllArgsConstructor
public enum Role {

    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant"),
    FUNCTION("function"),
    ;

    private final String name;
}
