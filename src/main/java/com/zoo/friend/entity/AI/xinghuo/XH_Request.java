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
 * @date 2023/10/14 14:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class XH_Request implements Serializable {
    private Header header;
    private XH_Parameter parameter;
    private XH_Payload payload;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header {
        private String app_id;
        private String uid;
    }


}
