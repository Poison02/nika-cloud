package com.zch.sys.modular.role.enums;

import com.zch.common.exception.CommonException;
import lombok.Getter;

/**
 * 角色分类枚举
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
public enum SysRoleCategoryEnum {

    /** 全局 */
    GLOBAL("GLOBAL"),

    /** 组织 */
    ORG("ORG");

    private final String value;

    SysRoleCategoryEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = GLOBAL.getValue().equals(value) || ORG.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的角色分类：{}", value);
        }
    }
}
