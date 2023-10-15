package com.zoo.friend.listener;

import com.alibaba.fastjson2.JSONObject;
import com.zoo.friend.entity.AI.xinghuo.MessageDTO;
import com.zoo.friend.entity.response.xinghuo.HeaderResponse;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ZooXHSourceListener extends WebSocketListener {

    @Override
    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        super.onOpen(webSocket, response);

    }

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        super.onMessage(webSocket, text);
        HeaderResponse responseData = JSONObject.parseObject(text,HeaderResponse.class);
        if(0 == responseData.getHeader().getCode()){

            HeaderResponse.Payload pl = responseData.getPayload();
            List<MessageDTO> tests = pl.getChoices().getText();
            MessageDTO textDTO = tests.stream().findFirst().orElse(new MessageDTO());
            System.out.println(textDTO.toString());

            if(2 == responseData.getHeader().getStatus()){
                HeaderResponse.Payload.Usage_x.xhUsage usage = pl.getUsage().getText();
                Integer totalTokens = usage.getTotal_tokens();
                System.out.println("本次花费："+totalTokens + " tokens");
                webSocket.close(3,"客户端主动断开链接");
            }


        }else{
            System.out.println("返回结果错误：\n" + responseData.getHeader().getCode()+  responseData.getHeader().getMessage() );
        }
    }

    @Override
    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
        super.onFailure(webSocket, t, response);
    }

    @Override
    public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        super.onClosed(webSocket, code, reason);
    }
}