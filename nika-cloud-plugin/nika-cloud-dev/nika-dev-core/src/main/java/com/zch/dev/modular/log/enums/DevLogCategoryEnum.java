package com.zch.dev.modular.log.enums;

import lombok.Getter;

/**
 * 日志分类枚举
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
public enum DevLogCategoryEnum {

    /** 操作日志 */
    OPERATE("OPERATE"),
    /** 异常日志 */
    EXCEPTION("EXCEPTION"),
    /** 登录日志 */
    LOGIN("LOGIN"),
    /** 登出日志 */
    LOGOUT("LOGOUT");

    private final String value;

    DevLogCategoryEnum(String value) {
        this.value = value;
    }
}
