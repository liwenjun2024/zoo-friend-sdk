package com.zoo.friend.exception;

import com.zoo.friend.common.ErrorCode;
import lombok.Getter;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 13:50
 */
@Getter
public class BusinessException extends RuntimeException {


    int code;


    String msg;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
}
