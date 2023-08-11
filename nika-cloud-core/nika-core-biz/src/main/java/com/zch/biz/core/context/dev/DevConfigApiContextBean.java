package com.zch.biz.core.context.dev;

import com.zch.dev.api.DevConfigApi;
import com.zch.dev.feign.DevConfigFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@Slf4j
@Component
@RequiredArgsConstructor
public class DevConfigApiContextBean implements DevConfigApi {

    private final DevConfigFeign devConfigFeign;

    /**
     * 根据键获取值
     */
    @Override
    public String getValueByKey(String key) {
        return devConfigFeign.getValueByKey(key);
    }

}
