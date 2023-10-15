package com.zoo.friend.entity.AI.xinghuo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/10/14 14:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class XH_Parameter implements Serializable {
    private chat chat;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class chat{

        private String domain;
        private Double temperature;
        private Integer max_tokens;
    }
}


