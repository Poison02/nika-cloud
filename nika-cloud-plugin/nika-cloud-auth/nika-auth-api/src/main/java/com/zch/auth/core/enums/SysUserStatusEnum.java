package com.zch.auth.core.enums;

import com.zch.common.exception.CommonException;
import lombok.Getter;

/**
 * 用户状态枚举
 * @author Zch
 * @date 2023/8/6
 **/
@Getter
public enum SysUserStatusEnum {

    ENABLE("ENABLE"),
    DISABLED("DISABLED");

    private final String value;

    SysUserStatusEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = ENABLE.getValue().equals(value) || DISABLED.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的用户状态：{}", value);
        }
    }
}
