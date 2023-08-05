package com.zch.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通用基础配置
 * @author Zch
 * @date 2023/8/5
 **/
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "snowy.config.common")
public class CommonProperties {

    /**
     * 前端地址
     */
    private String frontUrl;

    /**
     * 后端地址
     */
    private String backendUrl;
}
