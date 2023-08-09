package com.zch.dev.modular.job.enums;

import com.zch.exception.CommonException;
import lombok.Getter;

/**
 * 定时任务状态枚举
 * @author Zch
 * @date 2023/8/9
 **/
@Getter
public enum DevJobStatusEnum {

    RUNNING("RUNNING"),

    STOPPED("STOPPED");

    private final String value;

    DevJobStatusEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = RUNNING.getValue().equals(value) || STOPPED.getValue().equals(value);
        if (! flag) {
            throw new CommonException("不支持的定时任务状态：{}", value);
        }
    }
}
