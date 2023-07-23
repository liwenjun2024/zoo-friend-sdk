package com.zoo.friend.listener;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 15:41
 */
@Slf4j
public class LogEventSourceListener extends okhttp3.sse.EventSourceListener {
    @Override
    public void onOpen(@NotNull EventSource eventSource, @NotNull Response response) {
        log.info("建立sse连接");
    }

    @Override
    public void onEvent(@NotNull EventSource eventSource, @Nullable String id, @Nullable String type, @NotNull String data) {
        log.info("返回数据");
    }

    @Override
    public void onClosed(@NotNull EventSource eventSource) {
        log.info("关闭sse连接");
    }

    @Override
    public void onFailure(@NotNull EventSource eventSource, @Nullable Throwable t, @Nullable Response response) {
        log.info("失败咯");
    }

}
