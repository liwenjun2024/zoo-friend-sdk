package com.zoo.friend.entity.AI.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zoo.friend.constant.Role;
import io.micrometer.common.util.StringUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 咏鹅
 * @version 1.0
 * @description TODO
 * @date 2023/7/23 17:18
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatGPTMessage implements Serializable {

    private String role;
    private String content;
    private String name;

    public static PartyRun Party() {
        return new PartyRun();
    }

    public ChatGPTMessage(){

    }

    public ChatGPTMessage(PartyRun run) {
        if (!StringUtils.isEmpty(run.role)) {
            role = run.role;
        } else role = Role.USER.getName();
        if (!StringUtils.isEmpty(run.content)) {
            content = run.content;
        }
        if (StringUtils.isEmpty(run.name)) {
            name = run.name;
        }
    }


    public static final class PartyRun {
        private String role;
        private String content;
        private String name;


        public PartyRun setRole(Role role) {
            this.role = role.getName();
            return this;
        }


        public PartyRun setContent(String content) {
            this.content = content;
            return this;
        }

        public PartyRun setName(String name) {
            this.name = name;
            return this;
        }

        public ChatGPTMessage partyRun() {
            return new ChatGPTMessage(this);
        }
    }


}
