package com.zoo.friend.entity.AI.xinghuo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/10/14 14:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class XH_Payload {
    private Message message;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class Message {
        private List<MessageDTO> text;


    }
}
