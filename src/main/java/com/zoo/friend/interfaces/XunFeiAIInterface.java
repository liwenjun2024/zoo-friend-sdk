package com.zoo.friend.interfaces;

import com.zoo.friend.entity.response.xinghuo.HeaderResponse;
import io.reactivex.rxjava3.core.Single;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.http.POST;

import javax.annotation.processing.Completion;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/10/14 14:35
 */
public interface XunFeiAIInterface {

    @PostMapping("/v2.1/chat")
    Single<HeaderResponse> completions(@RequestBody Completion completion);
}
