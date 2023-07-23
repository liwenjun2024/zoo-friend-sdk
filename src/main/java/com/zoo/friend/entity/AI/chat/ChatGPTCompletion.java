package com.zoo.friend.entity.AI.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zoo.friend.constant.GPTModel;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 18:12
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTCompletion implements Serializable {

    @Builder.Default
    private String model = GPTModel.GPT_3_5_TURBO.getName();
    @NonNull
    private List<ChatGPTMessage> messages;

    private List<ChatGPTFunction> functions;

    private Object function_call;

    @Builder.Default
    private double temperature = 0.2;

    @Builder.Default
    private Double top_p = 1d;

    //每个提示生成的完成次数。
    @Builder.Default
    private Integer n = 1;

    //是否流式输出
    @Builder.Default
    private boolean stream = false;

    //停止输出标识
    private List<String> stop;

    /**
     * 最大支持4096
     */
    @Builder.Default
    private Integer max_tokens = 2048;



    @Builder.Default
    private double presence_penalty = 0;

    /**
     * -2.0 ~~ 2.0
     */
    @Builder.Default
    private double frequency_penalty = 0;

    private Map logit_bias;

    //用户唯一值
    private String user;


}
