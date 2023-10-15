package com.zoo.friend.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/10/14 14:17
 */
@AllArgsConstructor
@Getter
public enum XingHuoModel {

    /**
    * 星火v1.5
    */
    XING_HUO_1_5_MODEL("v1.1"),
    /**
     * 星火v2.0
     */
    XING_HUO_2_0_MODEL("v2.1")
    ;

    private final String name;
}
