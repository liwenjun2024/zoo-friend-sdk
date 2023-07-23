package com.zoo.friend.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zoo.friend.entity.common.Usage;
import lombok.Data;

import java.awt.*;
import java.io.Serializable;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 0:33
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProblemResponse extends OpenAIResponse implements Serializable {

    private String id;
    private String object;
    private long created;
    private String model;
    private Choice[] choices;
    private Usage usage;

}
