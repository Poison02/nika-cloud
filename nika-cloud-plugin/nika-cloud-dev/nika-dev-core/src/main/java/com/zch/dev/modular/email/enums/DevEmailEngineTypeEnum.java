package com.zch.dev.modular.email.enums;

import lombok.Getter;

/**
 * 邮件发送引擎类型枚举
 * @author Zch
 * @date 2023/8/8
 **/
@Getter
public enum DevEmailEngineTypeEnum {

    LOCAL("LOCAL"),

    ALIYUN("ALIYUN"),

    TENCENT("TENCENT");

    private final String value;

    DevEmailEngineTypeEnum(String value) {
        this.value = value;
    }
}
