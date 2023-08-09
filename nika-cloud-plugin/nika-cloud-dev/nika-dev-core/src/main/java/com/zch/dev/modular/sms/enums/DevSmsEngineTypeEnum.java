package com.zch.dev.modular.sms.enums;

import lombok.Getter;

/**
 * 短信发送引擎类型枚举
 * @author Zch
 * @date 2023/8/9
 **/
@Getter
public enum DevSmsEngineTypeEnum {

    ALIYUN("ALIYUN"),

    TENCENT("TENCENT");

    private final String value;

    DevSmsEngineTypeEnum(String value) {
        this.value = value;
    }
}
