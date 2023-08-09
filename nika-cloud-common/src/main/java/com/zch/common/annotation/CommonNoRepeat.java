package com.zch.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义节流防抖注解
 * @author Zch
 * @date 2023/8/5
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CommonNoRepeat {

    /**
     * 间隔时间（ms），小于此事件视为重复提交，默认5000ms
     */
    int interval() default 5000;

}
