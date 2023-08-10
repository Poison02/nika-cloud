package com.zch.auth.modular.third.enums;

import com.zch.common.exception.CommonException;
import lombok.Getter;

/**
 * 第三方登录平台枚举
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
public enum AuthThirdPlatformEnum {

    /**
     * GITEE
     */
    GITEE("GITEE"),

    /**
     * WECHAT
     */
    WECHAT("WECHAT");

    private final String value;

    AuthThirdPlatformEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = GITEE.getValue().equals(value) || WECHAT.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的第三方平台：{}", value);
        }
    }

}
