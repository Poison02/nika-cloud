package com.zch.dev.modular.relation.enums;

import lombok.Getter;

/**
 * 关系分类枚举
 * @author Zch
 * @date 2023/8/9
 **/
@Getter
public enum DevRelationCategoryEnum {

    FILE_TO_BIZ_DEFAULT("FILE_TO_BIZ_DEFAULT"),

    MSG_TO_USER("MSG_TO_USER");

    private final String value;

    DevRelationCategoryEnum(String value) {
        this.value = value;
    }
}
