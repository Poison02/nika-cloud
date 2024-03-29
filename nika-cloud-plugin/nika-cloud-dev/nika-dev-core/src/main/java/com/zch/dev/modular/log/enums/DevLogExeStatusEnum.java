package com.zch.dev.modular.log.enums;

import lombok.Getter;

/**
 * 日志执行状态枚举
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
public enum DevLogExeStatusEnum {
    /** 成功 */
    SUCCESS("SUCCESS"),
    /** 失败 */
    FAIL("FAIL");

    private final String value;

    DevLogExeStatusEnum(String value) {
        this.value = value;
    }
}
