package com.zch.dev.feign;

import com.zch.common.consts.FeignConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@FeignClient(name= FeignConstant.WEB_APP, contextId = "DevConfigFeign")
public interface DevConfigFeign {

    /**
     * 根据键获取值
     **/
    @RequestMapping("/feign/dev/config/getValueByKey")
    String getValueByKey(@RequestParam("key") String key);

}
