package com.zch.annotation;

import com.zch.pojo.CommonWrapperInterface;

import java.lang.annotation.*;

/**
 * 自定义包装注解，对相应结果进行包装
 * @author Zch
 * @date 2023/8/5
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CommonWrapper {

    Class<? extends CommonWrapperInterface<?>> [] value();

}
