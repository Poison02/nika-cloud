package com.zch.dev.core.aop;

import cn.hutool.core.util.ObjectUtil;
import com.zch.annotation.CommonLog;
import com.zch.auth.core.pojo.SaBaseLoginUser;
import com.zch.auth.core.util.StpLoginUserUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 业务日志aop
 * @author Zch
 * @date 2023/8/7
 **/
@Aspect
@Order
@Component
public class DevLogAop {

    /**
     * 日志切入点
     */
    @Pointcut("@@annotation(com.zch.common.annotation.CommonLog)")
    private void getLogPointCut() {}

    @AfterReturning(pointcut = "getLogPointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        CommonLog commonLog = method.getAnnotation(CommonLog.class);
        String userName = "未知";
        try {
            SaBaseLoginUser loginUser = StpLoginUserUtil.getLoginUser();
            if (ObjectUtil.isNotNull(loginUser)) {
                userName = loginUser.getName();
            }
        } catch (Exception e) {
        }
        // 异步记录日志

    }

}
