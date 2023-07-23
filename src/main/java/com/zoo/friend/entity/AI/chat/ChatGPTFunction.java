package com.zoo.friend.entity.AI.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.login.Configuration;
import java.io.Serializable;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 18:25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTFunction implements Serializable {
    //方法名称
    private String name;
    //方法描述
    private String description;
    //方法参数,实现json格式的数据
    private ChatGPTParameters parameters;
}
/**
 * @description 官网参数
 * @param null
 * @return         {
 *             "name": "get_current_weather",
 *             "description": "Get the current weather in a given location",
 *             "parameters": {
 *                 "type": "object",
 *                 "properties": {
 *                     "location": {
 *                         "type": "string",
 *                         "description": "The city and state, e.g. San Francisco, CA",
 *                     },
 *                     "unit": {"type": "string", "enum": ["celsius", "fahrenheit"]},
 *                 },
 *                 "required": ["location"],
 *             },
 *         }
 * @author 咏鹅
 * @date 2023/7/23 18:28
*/