package com.zch.biz.core.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Optional;

/**
 * OpenFeign请求拦截器
 * @author Zch
 * @date 2023/8/11
 **/
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            Optional.ofNullable(headerNames).ifPresent(headers -> {
                while (headers.hasMoreElements()) {
                    String name = headers.nextElement();
                    String value = request.getHeader(name);

                    // 跳过 content-length
                    if ("content-length".equals(name)){
                        continue;
                    }

                    requestTemplate.header(name, value);
                    log.info(">>> feign header set key:{}, value:{}", name, value);
                }
            });
        }
    }
}
