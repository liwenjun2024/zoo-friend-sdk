package com.zoo.friend.entity.models.openai;

import lombok.*;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 14:19
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    @Builder.Default
    private Integer max_tokens = 4096;

    //用户
    private String user;

    //问题详情
    private String description;

    //流式
    private boolean stream = false;

    @Builder.Default
    private String model = Model.TEXT_DAVINCI_003.getName();

    @Getter
    @AllArgsConstructor
    private enum Model{


        TEXT_ADA_001("text-ada-001"),
        TEXT_BABBAGE_001("text-babbage-001"),
        TEST_CURIE_001("text-curie-001"),
        TEXT_DAVINCI_003("text-davinci-003"),
        ;
        private final String name;

    }
}
