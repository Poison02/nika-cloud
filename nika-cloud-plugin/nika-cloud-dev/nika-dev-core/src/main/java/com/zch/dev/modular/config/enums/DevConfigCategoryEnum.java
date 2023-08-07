package com.zch.dev.modular.config.enums;

import com.zch.exception.CommonException;
import lombok.Getter;

/**
 * 配置 枚举
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
public enum DevConfigCategoryEnum {

    /**
     * 系统基础
     */
    SYS_BASE("SYS_BASE"),

    /**
     * 业务定义
     */
    BIZ_DEFINE("BIZ_DEFINE"),

    /**
     * 三方登录-码云
     */
    THIRD_GITEE("THIRD_GITEE"),

    /**
     * 三方登录-微信
     */
    THIRD_WECHAT("THIRD_WECHAT"),

    /**
     * 文件-本地
     */
    FILE_LOCAL("FILE_LOCAL"),

    /**
     * 文件-腾讯云
     */
    FILE_TENCENT("FILE_TENCENT"),

    /**
     * 文件-阿里云
     */
    FILE_ALIYUN("FILE_ALIYUN"),

    /**
     * 文件-MINIO
     */
    FILE_MINIO("FILE_MINIO"),

    /**
     * 邮件-本地
     */
    EMAIL_LOCAL("EMAIL_LOCAL"),

    /**
     * 邮件-腾讯云
     */
    EMAIL_TENCENT("EMAIL_TENCENT"),

    /**
     * 邮件-阿里云
     */
    EMAIL_ALIYUN("EMAIL_ALIYUN"),

    /**
     * 短信-腾讯云
     */
    SMS_TENCENT("SMS_TENCENT"),

    /**
     * 短信-阿里云
     */
    SMS_ALIYUN("SMS_ALIYUN"),

    /**
     * 支付-支付宝
     */
    PAY_ALI("PAY_ALI"),

    /**
     * 支付-微信
     */
    PAY_WX("PAY_WX");

    private final String value;

    DevConfigCategoryEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = SYS_BASE.getValue().equals(value) || BIZ_DEFINE.getValue().equals(value) ||
                THIRD_GITEE.getValue().equals(value) || THIRD_WECHAT.getValue().equals(value) ||
                FILE_LOCAL.getValue().equals(value) || FILE_TENCENT.getValue().equals(value) ||
                FILE_ALIYUN.getValue().equals(value) || FILE_MINIO.getValue().equals(value) ||
                EMAIL_TENCENT.getValue().equals(value) || EMAIL_ALIYUN.getValue().equals(value) ||
                SMS_TENCENT.getValue().equals(value) || SMS_ALIYUN.getValue().equals(value) ||
                PAY_ALI.getValue().equals(value) || PAY_WX.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的配置分类：{}", value);
        }
    }

}
