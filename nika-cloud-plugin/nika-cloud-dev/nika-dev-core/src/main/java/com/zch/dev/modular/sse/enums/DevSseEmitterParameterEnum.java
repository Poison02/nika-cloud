package com.zch.dev.modular.sse.enums;

import lombok.Getter;

/**
 * SSE 通信参数枚举
 * @author Zch
 * @date 2023/8/9
 **/
@Getter
public enum DevSseEmitterParameterEnum {

    /**
     * 通信
     */
    EMITTER("EMITTER"),

    /**
     * 心跳
     */
    FUTURE("FUTURE"),

    /**
     * 用户ID
     */
    LOGINID("LOGINID");

    private final String value;

    DevSseEmitterParameterEnum(String value) {
        this.value = value;
    }

}
