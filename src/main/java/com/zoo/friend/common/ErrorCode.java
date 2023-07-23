package com.zoo.friend.common;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 13:28
 */
public enum ErrorCode {

    APIKEY_ERROR(11,"apikey错误"),
    HOST_ERROR(22,"地址错误");

    //后续可以添入官方错误码

    public int getCode() {
        return code;
    }

    private int code;
    private String msg;

    ErrorCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


}
