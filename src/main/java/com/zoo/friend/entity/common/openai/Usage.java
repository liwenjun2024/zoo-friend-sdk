package com.zoo.friend.entity.common.openai;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 0:42
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usage {

    private long question_tokens;
    private long prompt_tokens;
    private long completion_tokens;
    private long total_tokens;
}
