package com.zch.auth.core.enums;

import com.zch.exception.CommonException;
import lombok.Getter;

/**
 * 登录端类型枚举
 * @author Zch
 * @date 2023/8/6
 **/
@Getter
public enum SaClientTypeEnum {

    B("B"),
    C("C");

    private final String value;

    SaClientTypeEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = B.getValue().equals(value) || C.getValue().equals(value);
        if (!flag) {
            throw new CommonException("不支持的登录端类型: {}", value);
        }
    }
}
