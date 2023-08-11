package com.zch.dev.feign;

import com.zch.common.consts.FeignConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@FeignClient(name= FeignConstant.WEB_APP, contextId = "DevFeign")
public interface DevFeign {

    /**
     * 初始化ID类型的租户开发工具模块数据
     **/
    @RequestMapping("/feign/dev/initTenDataForCategoryId")
    void initTenDataForCategoryId(@RequestParam("tenId") String tenId, @RequestParam("tenName") String tenName);

    /**
     * 删除ID类型的租户开发工具模块数据
     **/
    @RequestMapping("/feign/dev/removeTenDataForCategoryId")
    void removeTenDataForCategoryId(@RequestParam("tenId") String tenId);

}
