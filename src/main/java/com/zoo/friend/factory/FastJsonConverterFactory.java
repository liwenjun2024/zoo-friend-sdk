package com.zoo.friend.factory;

import cn.hutool.http.ContentType;
import com.alibaba.fastjson2.JSON;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 16:26
 */
public class FastJsonConverterFactory extends Converter.Factory {

    public static FastJsonConverterFactory create(){
        return new FastJsonConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return super.responseBodyConverter(type, annotations, retrofit);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }

    private static class FastJsonRequestBodyConverter<T> implements Converter<T,RequestBody>{

        @Override
        public RequestBody convert(T value) throws IOException {
            String json = JSON.toJSONString(value);
            return RequestBody.create(json,MediaType.parse(ContentType.JSON.getValue()));
        }
    }

    private record FastJsonResponseBodyConverter<T>(Type type) implements Converter<ResponseBody, T> {

        @Override
            public T convert(ResponseBody value) throws IOException {
                String json = value.string();
                return JSON.parseObject(json,type);
            }
        }
}
