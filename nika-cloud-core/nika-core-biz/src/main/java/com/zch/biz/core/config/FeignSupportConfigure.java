package com.zch.biz.core.config;

import com.zch.biz.core.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * openFeign全局配置
 * @author Zch
 * @date 2023/8/11
 **/
@Configuration
public class FeignSupportConfigure {

    /**
     * feign请求拦截器
     */
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignRequestInterceptor();
    }

}
