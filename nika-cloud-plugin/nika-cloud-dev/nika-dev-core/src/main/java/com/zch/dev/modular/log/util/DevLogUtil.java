package com.zch.dev.modular.log.util;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.zch.common.annotation.CommonLog;
import com.zch.common.util.*;
import com.zch.dev.modular.log.entity.DevLog;
import com.zch.dev.modular.log.enums.DevLogCategoryEnum;
import com.zch.dev.modular.log.enums.DevLogExeStatusEnum;
import com.zch.dev.modular.log.service.DevLogService;
import com.zch.common.util.*;
import org.aspectj.lang.JoinPoint;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zch
 * @date 2023/8/7
 **/
public class DevLogUtil {

    private static final DevLogService devLogService = SpringUtil.getBean(DevLogService.class);

    /**
     * 记录操作日志
     * @param commonLog
     * @param userName
     * @param joinPoint
     * @param resultJson
     */
    public static void executeOperationLog(CommonLog commonLog, String userName, JoinPoint joinPoint, String resultJson) {
        HttpServletRequest request = CommonServletUtil.getRequest();
        DevLog devLog = genBaseOpLog();
        ThreadUtil.execute(() -> {
            devLog.setCategory(DevLogCategoryEnum.OPERATE.getValue());
            devLog.setName(commonLog.value());
            devLog.setClassName(joinPoint.getTarget().getClass().getName());
            devLog.setMethodName(joinPoint.getSignature().getName());
            devLog.setReqMethod(request.getMethod());
            devLog.setReqUrl(request.getRequestURI());
            devLog.setParamJson(CommonJoinPointUtil.getArgsJsonString(joinPoint));
            devLog.setResultJson(resultJson);
            devLog.setOpTime(DateTime.now());
            devLog.setOpUser(userName);
            createLogSignValue(devLog);
            devLogService.save(devLog);
        });
    }

    /**
     * 记录异常日志
     * @param commonLog
     * @param userName
     * @param joinPoint
     * @param exception
     */
    public static void executeExceptionLog(CommonLog commonLog, String userName, JoinPoint joinPoint, Exception exception) {
        HttpServletRequest request = CommonServletUtil.getRequest();
        DevLog devLog = genBaseOpLog();
        ThreadUtil.execute(() -> {
            devLog.setCategory(DevLogCategoryEnum.EXCEPTION.getValue());
            devLog.setName(commonLog.value());
            devLog.setExeStatus(DevLogExeStatusEnum.FAIL.getValue());
            devLog.setExeMessage(ExceptionUtil.stacktraceToString(exception, Integer.MAX_VALUE));
            devLog.setClassName(joinPoint.getTarget().getClass().getName());
            devLog.setMethodName(joinPoint.getSignature().getName());
            devLog.setReqMethod(request.getMethod());
            devLog.setReqUrl(request.getRequestURI());
            devLog.setParamJson(CommonJoinPointUtil.getArgsJsonString(joinPoint));
            devLog.setOpTime(DateTime.now());
            devLog.setOpUser(userName);
            createLogSignValue(devLog);
            devLogService.save(devLog);
        });
    }

    /**
     * 记录登录日志
     * @param userName
     */
    public static void executeLoginLog(String userName) {
        DevLog devLog = genBaseOpLog();
        ThreadUtil.execute(() -> {
            devLog.setCategory(DevLogCategoryEnum.LOGIN.getValue());
            devLog.setName("用户登录");
            devLog.setExeStatus(DevLogExeStatusEnum.SUCCESS.getValue());
            devLog.setOpTime(DateTime.now());
            devLog.setOpUser(userName);
            createLogSignValue(devLog);
            devLogService.save(devLog);
        });
    }

    /**
     * 记录登出日志
     */
    public static void executeLogoutLog(String userName) {
        DevLog devLog = genBaseOpLog();
        ThreadUtil.execute(() -> {
            devLog.setCategory(DevLogCategoryEnum.LOGOUT.getValue());
            devLog.setName("用户登出");
            devLog.setExeStatus(DevLogExeStatusEnum.SUCCESS.getValue());
            devLog.setOpTime(DateTime.now());
            devLog.setOpUser(userName);
            createLogSignValue(devLog);
            devLogService.save(devLog);
        });
    }

    private static DevLog genBaseOpLog() {
        HttpServletRequest request = CommonServletUtil.getRequest();
        String ip = CommonIpAddressUtil.getIp(request);
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
            if (ObjectUtil.isEmpty(loginId)) {
                loginId = "-1";
            }
        } catch (Exception e) {
            loginId = "-1";
        }
        DevLog devLog = new DevLog();
        devLog.setOpIp(CommonIpAddressUtil.getIp(request));
        devLog.setOpAddress(CommonIpAddressUtil.getCityInfo(ip));
        devLog.setOpBrowser(CommonUaUtil.getBrowser(request));
        devLog.setOpOs(CommonUaUtil.getOs(request));
        devLog.setCreateUser(loginId);
        return devLog;
    }

    private static void createLogSignValue(DevLog devLog) {
        String logStr = devLog.toString().replaceAll(" +", "");
        devLog.setSignData(CommonCryptogramUtil.doSignature(logStr));
    }

}
