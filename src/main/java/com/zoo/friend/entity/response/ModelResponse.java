package com.zoo.friend.entity.response;

import com.zoo.friend.entity.models.Model;

import java.io.Serializable;
import java.util.List;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 0:47
 */
public class ModelResponse implements Serializable {

    private String object;
    private List<Model> data;
}
