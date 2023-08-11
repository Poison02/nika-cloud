package com.zch.web.core.provider.sys.position;

import cn.hutool.json.JSONUtil;
import com.zch.sys.feign.SysPositionFeign;
import com.zch.sys.modular.position.provider.SysPositionApiProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/8/11
 **/

@Slf4j
@RequiredArgsConstructor
@RestController
public class SysPositionFeignProvider implements SysPositionFeign {

    private final SysPositionApiProvider sysPositionApiProvider;

    /**
     * 根据id获取名称
     */
    @Override
    @RequestMapping("/feign/sys/position/getNameById")
    public String getNameById(@RequestParam(value = "positionId",required = false) String positionId) {
        return sysPositionApiProvider.getNameById(positionId);
    }

    /**
     * 获取职位选择器
     */
    @Override
    @RequestMapping("/feign/sys/position/positionSelector")
    public String positionSelector(@RequestParam(value = "orgId",required = false) String orgId, @RequestParam(value = "searchKey",required = false) String searchKey) {
        return JSONUtil.toJsonStr(sysPositionApiProvider.positionSelector(orgId, searchKey));
    }
}
