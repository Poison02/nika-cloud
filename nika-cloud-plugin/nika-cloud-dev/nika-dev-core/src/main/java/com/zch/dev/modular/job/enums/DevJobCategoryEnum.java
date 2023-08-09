package com.zch.dev.modular.job.enums;

import com.zch.exception.CommonException;
import lombok.Getter;

/**
 * 定时任务分类枚举
 * @author Zch
 * @date 2023/8/9
 **/
@Getter
public enum DevJobCategoryEnum {

    /* 框架 */
    FRM("FRM"),

    /* 业务 */
    BIZ("BIZ");

    private final String value;

    DevJobCategoryEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = FRM.getValue().equals(value) || BIZ.getValue().equals(value);
        if (! flag) {
            throw new CommonException("不支持的定时任务分类： {}", value);
        }
    }


}
