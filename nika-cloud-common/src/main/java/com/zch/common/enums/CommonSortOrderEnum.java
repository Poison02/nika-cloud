package com.zch.common.enums;

import com.zch.common.exception.CommonException;
import lombok.Getter;

/**
 * 通用排序方式枚举
 * @author Zch
 * @date 2023/8/5
 **/
@Getter
public enum CommonSortOrderEnum {

    ASC("ASCEND"),

    DESC("DESCEND");

    private final String value;

    CommonSortOrderEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = ASC.getValue().toLowerCase().equals(value) || DESC.getValue().toLowerCase().equals(value);
        if (!flag) {
            throw new CommonException("不支持该排序方式：{}", value);
        }
    }
}
