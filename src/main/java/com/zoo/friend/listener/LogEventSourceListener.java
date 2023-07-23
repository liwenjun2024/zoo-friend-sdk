package com.zoo.friend.listener;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 15:41
 */
@Slf4j
public class LogEventSourceListener extends EventSourceListener {
    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.info("建立sse连接");
    }

    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        log.info("OpenAI 返回数据: {}",data);
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
