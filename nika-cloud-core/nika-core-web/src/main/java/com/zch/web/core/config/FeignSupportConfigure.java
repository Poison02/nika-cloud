package com.zch.web.core.config;

import com.zch.web.core.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenFeign全局配置注册
 * @author Zch
 * @date 2023/8/11
 **/
@Configuration
public class FeignSupportConfigure {

    /**
     * 注册请求拦截器
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }

}
