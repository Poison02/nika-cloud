package com.zch.auth.core.annotation;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.zch.auth.core.util.StpClientUtil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录认证
 * @author Zch
 * @date 2023/8/6
 **/
@SaCheckLogin(type = StpClientUtil.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE})
public @interface SaClientCheckLogin {
}
