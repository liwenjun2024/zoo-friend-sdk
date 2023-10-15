package com.zoo.friend.entity.response.xinghuo;

import com.zoo.friend.entity.AI.xinghuo.MessageDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/10/14 14:38
 */
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class HeaderResponse implements Serializable {
    private Header header;

    private Payload payload;


    @NoArgsConstructor
    @Data
    public static class Header{
        private Integer code;
        private String message;
        private String sid;
        private Integer status;
    }

    @NoArgsConstructor
    @Data
    public static class Payload{
        private Choices choices;

        private Usage_x usage;

        @NoArgsConstructor
        @Data
        public static class Choices{
            private Integer status;
            private Integer seq;
            private List<MessageDTO> text;
        }

        @NoArgsConstructor
        @Data
        public static class Usage_x{
            private xhUsage text;

            @Data
            @NoArgsConstructor
            public static class xhUsage{
                private Integer question_tokens;
                private Integer prompt_tokens;
                private Integer completion_tokens;
                private Integer total_tokens;
            }
        }
    }

}
