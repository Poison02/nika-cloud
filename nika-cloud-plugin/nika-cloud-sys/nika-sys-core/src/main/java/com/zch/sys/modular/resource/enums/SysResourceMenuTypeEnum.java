package com.zch.sys.modular.resource.enums;

import com.zch.common.exception.CommonException;
import lombok.Getter;

/**
 * 菜单类型枚举
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
public enum SysResourceMenuTypeEnum {

    /** 目录 */
    CATALOG("CATALOG"),

    /** 组件 */
    MENU("MENU"),

    /** 内链 */
    IFRAME("IFRAME"),

    /** 外链 */
    LINK("LINK");

    private final String value;

    SysResourceMenuTypeEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = CATALOG.getValue().equals(value) || MENU.getValue().equals(value) || IFRAME.getValue().equals(value) ||
                LINK.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的菜单类型：{}", value);
        }
    }
}
