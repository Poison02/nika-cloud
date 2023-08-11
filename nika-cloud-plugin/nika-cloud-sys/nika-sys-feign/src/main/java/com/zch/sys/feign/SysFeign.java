package com.zch.sys.feign;

import com.zch.common.consts.FeignConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@FeignClient(name = FeignConstant.WEB_APP, contextId = "SysFeign")
public interface SysFeign {

    /**
     * 初始化ID类型的租户系统模块数据
     **/
    @RequestMapping("/feign/sys/initTenDataForCategoryId")
    void initTenDataForCategoryId(@RequestParam(value = "tenId",required = false) String tenId, @RequestParam(value = "tenName",required = false) String tenName);

    /**
     * 删除ID类型的租户系统模块数据
     **/
    @RequestMapping("/feign/sys/removeTenDataForCategoryId")
    void removeTenDataForCategoryId(@RequestParam(value = "tenId",required = false) String tenId);

}
