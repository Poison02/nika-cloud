package com.zch.util;

import cn.hutool.core.util.ObjectUtil;
import com.zch.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServlet工具类，获取当前request和response
 * @author Zch
 * @date 2023/8/5
 **/
@Slf4j
public class CommonServletUtil {

    public static String getParamFormRequest(String paramName) {
        HttpServletRequest request = CommonServletUtil.getRequest();

        // 1. 尝试从请求体里面获取
        String paramValue = request.getParameter(paramName);

        // 2. 尝试从请求头里面获取
        if (ObjectUtil.isEmpty(paramValue)) {
            paramValue = request.getHeader(paramName);
        }

        // 3. 尝试从cookie里读取
        if (ObjectUtil.isEmpty(paramValue)) {
            Cookie[] cookies = request.getCookies();
            if (ObjectUtil.isNotEmpty(cookies)) {
                for (Cookie cookie : cookies) {
                    String cookieName = cookie.getName();
                    if (cookieName.equals(paramName)) {
                        return cookie.getValue();
                    }
                }
            }
        }
        // 4. 返回
        return paramValue;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes;
        try {
            servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        } catch (Exception e) {
            log.error(">>> 非web上下文无法获取Request：", e);
            throw new CommonException("非Web上下文无法获取Request");
        }
        if (servletRequestAttributes == null) {
            throw new CommonException("非Web上下文无法获取Request");
        } else {
            return servletRequestAttributes.getRequest();
        }
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes;
        try {
            servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        } catch (Exception e) {
            log.error(">>> 非web上下文无法获取Request：", e);
            throw new CommonException("非Web上下文无法获取Request");
        }
        if (servletRequestAttributes == null) {
            throw new CommonException("非Web上下文无法获取Request");
        } else {
            return servletRequestAttributes.getResponse();
        }
    }

    public static boolean isWeb() {
        return RequestContextHolder.getRequestAttributes() != null;
    }

}
