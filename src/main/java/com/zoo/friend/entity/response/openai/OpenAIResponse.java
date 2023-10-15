package com.zoo.friend.entity.response.openai;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 0:35
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenAIResponse<T> implements Serializable {
    private String object;
    private List<T> data;
    private Error error;




    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        private String message;
        private String type;
        private String param;
        private String code;
    }
}
