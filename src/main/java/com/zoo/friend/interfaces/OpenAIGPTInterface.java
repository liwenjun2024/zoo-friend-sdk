package com.zoo.friend.interfaces;

import com.zoo.friend.entity.response.openai.ModelResponse;
import com.zoo.friend.entity.response.openai.ProblemResponse;
import io.reactivex.rxjava3.core.Single;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.processing.Completion;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 0:25
 */
public interface OpenAIGPTInterface {

    
    /**
     * @description 模型列表
     * 
     * @return 模型列表
     * @author 咏鹅
     * @date 2023/7/23 0:29
    */
    @GetMapping("/v1/models")
    Single<ModelResponse> models();

    /**
     * @description 对话接口
     * @param completion
     * @return 消息
     * @author 咏鹅
     * @date 2023/7/23 13:13
    */
    @PostMapping("/v1/completions")
    Single<ProblemResponse> completions(@RequestBody Completion completion);
}
