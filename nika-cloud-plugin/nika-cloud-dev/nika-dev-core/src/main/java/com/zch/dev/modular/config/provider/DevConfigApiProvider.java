package com.zch.dev.modular.config.provider;

import com.zch.dev.api.DevConfigApi;
import com.zch.dev.modular.config.service.DevConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Zch
 * @date 2023/8/7
 **/
@Service
public class DevConfigApiProvider implements DevConfigApi {

    @Resource
    private DevConfigService devConfigService;

    @Override
    public String getValueByKey(String key) {
        return devConfigService.getValueByKey(key);
    }
}
