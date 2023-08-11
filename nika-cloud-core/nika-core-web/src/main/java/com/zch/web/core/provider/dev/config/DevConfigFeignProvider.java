package com.zch.web.core.provider.dev.config;

import com.zch.dev.api.DevFileApi;
import com.zch.dev.feign.DevConfigFeign;
import com.zch.dev.modular.config.provider.DevConfigApiProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@Slf4j
@RequiredArgsConstructor
@RestController
public class DevConfigFeignProvider implements DevConfigFeign {

    @Resource
    private DevConfigApiProvider devConfigApiProvider;

    @Override
    @PostMapping("/feign/dev/config/getValueByKey")
    public String getValueByKey(@RequestParam("key") String key) {
        return devConfigApiProvider.getValueByKey(key);
    }
}
