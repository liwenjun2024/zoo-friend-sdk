package com.zoo.friend.listener;


import cn.hutool.db.Session;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoo.friend.common.ErrorCode;
import com.zoo.friend.entity.AI.chat.ChatGPTCompletion;
import com.zoo.friend.entity.response.ProblemResponse;
import com.zoo.friend.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Objects;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 15:41
 */

@AllArgsConstructor
@Slf4j
public class ZooEventSourceListener extends EventSourceListener {

    private SseEmitter sseEmitter;


    public ZooEventSourceListener(){

    }
    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.info("建立sse连接");
    }


    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        log.info("OpenAI 返回数据: {}",data);

        if(sseEmitter !=null && data.equals("[DONE]")){
            try {
                sseEmitter.send(SseEmitter.event()
                        .id("[DONE]")
                        .data("[DONE]")
                        .reconnectTime(3000));
            } catch (IOException e) {
                throw new BusinessException(ErrorCode.SSE_ERROR);
            }
            // 关闭sse
            sseEmitter.complete();
            return;
        }

        try{
            ObjectMapper mapper = new ObjectMapper();
            ProblemResponse problemResponse = mapper.readValue(data, ProblemResponse.class);
            sseEmitter.send(SseEmitter.event()
                    .id(problemResponse.getId())
                    .data(problemResponse.getChoices().get(0).getDelta())
                    .reconnectTime(3000));
        } catch (IOException e){
            throw new BusinessException(ErrorCode.SSE_ERROR);
        }

        if("[DONE]".equals(data)){
            log.info("返回数据结束");
            return;
        }
    }

    @Override
    public void onClosed(EventSource eventSource) {
        log.info("关闭sse连接");
    }

    @SneakyThrows
    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        if (Objects.isNull(response)) {
            log.error("OpenAI  sse连接异常:{}", t);
            eventSource.cancel();
            return;
        }
        ResponseBody body = response.body();
        if (Objects.nonNull(body)) {
            log.error("OpenAI  连接异常：{}，异常：{}", body.string(), t);
        } else {
            log.error("OpenAI  连接异常：{}，异常：{}", response, t);
        }
        eventSource.cancel();
    }

}
