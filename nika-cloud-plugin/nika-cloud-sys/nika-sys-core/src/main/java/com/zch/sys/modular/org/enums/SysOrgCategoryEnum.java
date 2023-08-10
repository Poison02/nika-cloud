package com.zch.sys.modular.org.enums;

import com.zch.common.exception.CommonException;
import lombok.Getter;

/**
 * 组织分类枚举
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
public enum SysOrgCategoryEnum {

    /** 公司 */
    COMPANY("COMPANY"),

    /** 部门 */
    DEPT("DEPT");

    private final String value;

    SysOrgCategoryEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = COMPANY.getValue().equals(value) || DEPT.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的组织分类：{}", value);
        }
    }
}
