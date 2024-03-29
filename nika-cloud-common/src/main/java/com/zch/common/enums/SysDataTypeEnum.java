package com.zch.common.enums;

import lombok.Getter;

/**
 * 系统模块数据类型枚举
 * @author Zch
 * @date 2023/8/5
 **/
@Getter
public enum SysDataTypeEnum {

    /**
     * 组织
     */
    ORG("ORG"),

    /**
     * 职位
     */
    POSITION("POSITION"),

    /**
     * 资源
     */
    RESOURCE("RESOURCE"),

    /**
     * 角色
     */
    ROLE("ROLE"),

    /**
     * 用户
     */
    USER("USER");

    private final String value;

    SysDataTypeEnum(String value) {
        this.value = value;
    }

}
