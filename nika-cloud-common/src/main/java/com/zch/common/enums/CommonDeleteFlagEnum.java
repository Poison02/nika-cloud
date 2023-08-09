package com.zch.common.enums;

import lombok.Getter;

/**
 * 通用删除标志枚举
 * @author Zch
 * @date 2023/8/5
 **/
@Getter
public enum CommonDeleteFlagEnum {

    /*
     * 未删除
     */
    NOT_DELETE,

    /*
     * 已删除
     */
    DELETED;

}
