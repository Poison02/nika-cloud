package com.zch.sys.feign;

import com.zch.common.consts.FeignConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@FeignClient(name= FeignConstant.WEB_APP, contextId = "SysPositionFeign")
public interface SysPositionFeign {

    /**
     * 根据id获取名称
     **/
    @RequestMapping("/feign/sys/position/getNameById")
    String getNameById(@RequestParam(value = "positionId",required = false) String positionId);

    /**
     * 获取职位选择器
     **/
    @RequestMapping("/feign/sys/position/positionSelector")
    String positionSelector(@RequestParam(value = "orgId",required = false) String orgId, @RequestParam(value = "searchKey",required = false) String searchKey);
}
