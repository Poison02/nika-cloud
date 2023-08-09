package com.zch.dev.modular.message.enums;

import lombok.Getter;

/**
 * 消息分类枚举
 * @author Zch
 * @date 2023/8/9
 **/
@Getter
public enum DevMessageCategoryEnum {

    SYS("SYS"),

    BIZ("BIZ");

    private final String value;

    DevMessageCategoryEnum(String value) {
        this.value = value;
    }
}
