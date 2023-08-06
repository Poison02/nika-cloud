package com.zch.auth.modular.login.enums;

import com.zch.exception.CommonException;
import lombok.Getter;

/**
 * 登录设备类型枚举
 * @author Zch
 * @date 2023/8/6
 **/
@Getter
public enum AuthDeviceTypeEnum {

    /**
     * PC端
     */
    PC("PC"),

    /**
     * 移动端
     */
    APP("APP"),

    /**
     * 小程序端
     */
    MINI("MINI");

    private final String value;

    AuthDeviceTypeEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = PC.getValue().equals(value) || APP.getValue().equals(value) || MINI.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的登录设备类型：{}", value);
        }
    }

}
