package com.zoo.friend.entity.AI.chat;

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
 * @date 2023/7/23 18:29
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTParameters implements Serializable {
    private List<String> required;
    private String type;
    private Object properties;
}

/**
 * @description 嵌套参数
 * @param null 
 * @return       "type": "object",
 *               "properties": {
 *                   "location": {
 *                       "type": "string",
 *                       "description": "The city and state, e.g. San Francisco, CA",
 *                   },
 *                   "unit": {"type": "string", "enum": ["celsius", "fahrenheit"]},
 *               },
 *               "required": ["location"],
 * @author 咏鹅
 * @date 2023/7/23 18:30
*/