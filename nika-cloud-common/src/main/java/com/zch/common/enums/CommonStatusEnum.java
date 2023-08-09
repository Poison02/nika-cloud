package com.zch.common.enums;

import lombok.Getter;

/**
 * 状态码枚举
 * @author Zch
 * @date 2023/8/5
 **/
@Getter
public enum CommonStatusEnum {

    OK(200, "请求成功"),
    NOT_LOGIN(401, "未登录"),
    NO_PERMISSION(403, "无权限"),
    PATH_NOT_EXIST(404, "路径不存在"),
    METHOD_INCORRECT(405, "请求方法不正确"),
    PARAMETER_ERROR(415, "参数传递异常"),
    BUSINESS_ERROR(500, "业务异常");

    private final Integer code;

    private final String message;

    CommonStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
