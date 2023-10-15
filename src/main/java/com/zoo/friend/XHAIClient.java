package com.zoo.friend;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.zoo.friend.constant.AIUrlConstant;
import com.zoo.friend.entity.AI.xinghuo.MessageDTO;
import com.zoo.friend.entity.AI.xinghuo.XH_Parameter;
import com.zoo.friend.entity.AI.xinghuo.XH_Payload;
import com.zoo.friend.entity.AI.xinghuo.XH_Request;
import io.micrometer.common.util.StringUtils;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/10/14 15:49
 */
public class XHAIClient {
    @Getter
    private String apiHost;
    @Getter
    private String apiPath;
    @Getter
    private String appId;
    @Getter
    private String apiKey;
    @Getter
    private String apiSecret;
    @Getter
    private String apiVersion;

    public static Builder builder() {
        return new Builder();
    }

    private XHAIClient(Builder builder) {
        if(StringUtils.isEmpty(builder.apiHost)){
            builder.apiHost = AIUrlConstant.XINGHUO_HOST_URL;
        }
        if(StringUtils.isEmpty(builder.apiVersion)){
            builder.apiPath = "/v2.1/chat";
        }else{
            builder.apiPath = "/"+ builder.apiVersion +"/chat";
        }
        this.apiHost = builder.apiHost;
        this.apiKey= builder.apiKey;
        this.apiPath = builder.apiPath;
        this.apiSecret = builder.apiSecret;
        this.appId = builder.appId;
    }


    public static final class Builder {
        private String apiHost;
        private String apiPath;
        private String appId;
        private String apiKey;
        private String apiSecret;

        private String apiVersion;

        public Builder(){

        }

        public Builder apiHost(String host){
            this.apiHost = host;
            return this;
        }
        public Builder apiPath(String Path){
            this.apiPath = Path;
            return this;
        }
        public Builder appId(String Id){
            this.appId = Id;
            return this;
        }
        public Builder apiKey(String Key){
            this.apiKey = Key;
            return this;
        }
        public Builder apiSecret(String secret){
            this.apiSecret = secret;
            return this;
        }
        public Builder apiVersion(String version){
            this.apiVersion = version;
            return this;
        }

        public XHAIClient build(){
            return new XHAIClient(this);
        }
    }

    public String getAuthorizationUrl(){
        try {
            // 获取鉴权时间 date
            SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            format.setTimeZone(TimeZone.getTimeZone("GMT"));
            String date = format.format(new Date());

            // 获取signature_origin字段
            StringBuilder strBuilder = new StringBuilder("host: ").append(this.apiHost).append("\n").
                    append("date: ").append(date).append("\n").
                    append("GET ").append(this.apiPath).append(" HTTP/1.1");

            // 加密
            Charset charset = StandardCharsets.UTF_8;
            Mac mac = Mac.getInstance("hmacsha256");
            SecretKeySpec sp = new SecretKeySpec(this.apiSecret.getBytes(charset),"hmacsha256");
            mac.init(sp);

            byte[] hexDigits = mac.doFinal(strBuilder.toString().getBytes(charset));
            String signature = Base64.getEncoder().encodeToString(hexDigits);
            //获得 authorization_origin
            String authorization_origin = String.format("api_key=\"%s\",algorithm=\"%s\",headers=\"%s\",signature=\"%s\"",this.apiKey,"hmac-sha256","host date request-line",signature);
            //获得authorization
            String authorization = Base64.getEncoder().encodeToString(authorization_origin.getBytes(charset));
            // 获取httpUrl
            Map<String,Object> param = new HashMap<>();
            param.put("authorization",authorization);
            param.put("date",date);
            param.put("host",this.apiHost);

            String toParams = HttpUtil.toParams(param);

            return "wss://" + this.apiHost + this.apiPath + "?" + toParams;
        }catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }

    /***
     * @description 获取请求参数
     * @param uid
     * @param message
     * @return com.zoo.friend.entity.AI.xinghuo.XH_Request
     * @author 咏鹅
     * @date 2023/10/15 0:31
    */
    public XH_Request getRequestParam(String uid, List<MessageDTO> message) {
        return XH_Request.builder().header(new XH_Request.Header(this.appId,uid))
                        .parameter(new XH_Parameter(new XH_Parameter.chat("generalv2",0.5,1024)))
                .payload(new XH_Payload(new XH_Payload.Message(message))).build();
    }

    /***
     * @description 发送消息
     * @param uid 
     * @param message 
     * @param listener
     * @return okhttp3.WebSocket
     * @author 咏鹅
     * @date 2023/10/15 0:30
    */
    public WebSocket sendMsg(String uid, List<MessageDTO> message, WebSocketListener listener) {
        // 获取鉴权url
        String authorizationUrl = this.getAuthorizationUrl();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request XHRequest = new Request.Builder().url(authorizationUrl).build();
        WebSocket webSocket = okHttpClient.newWebSocket(XHRequest,listener);

        XH_Request requestDTO = this.getRequestParam(uid,message);
        System.out.println("打印参数");
        System.out.println(JSONObject.toJSONString(requestDTO));
        webSocket.send(JSONObject.toJSONString(requestDTO));
        return webSocket;
    }

}
