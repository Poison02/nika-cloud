package com.zch.auth.core.annotation;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.zch.auth.core.util.StpClientUtil;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 角色认证
 * @author Zch
 * @date 2023/8/6
 **/
@SaCheckRole(type = StpClientUtil.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE})
public @interface SaClientCheckRole {

    /**
     * 需要校验的角色标识
     * @return 需要校验的角色标识
     */
    @AliasFor(annotation = SaCheckRole.class)
    String [] value() default {};

    /**
     * 验证模式：AND | OR，默认AND
     * @return 验证模式
     */
    @AliasFor(annotation = SaCheckRole.class)
    SaMode mode() default SaMode.AND;

}
