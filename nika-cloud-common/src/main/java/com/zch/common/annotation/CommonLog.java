package com.zch.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义日志注解
 * @author Zch
 * @date 2023/8/5
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CommonLog {

    /**
     * 日志的名称，例如：“修改菜单”...
     */
    String value() default "未命名";

}
