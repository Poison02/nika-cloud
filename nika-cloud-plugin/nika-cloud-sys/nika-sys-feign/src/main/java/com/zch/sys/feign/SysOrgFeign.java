package com.zch.sys.feign;

import com.zch.common.consts.FeignConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@FeignClient(name = FeignConstant.WEB_APP, contextId = "SysOrgFeign")
public interface SysOrgFeign {

    /**
     * 根据id获取名称
     **/
    @RequestMapping("/feign/sys/org/getNameById")
    String getNameById(@RequestParam(value = "orgId",required = false) String orgId);

    /**
     * 根据组织id获取部门主管id
     **/
    @RequestMapping("/feign/sys/org/getSupervisorIdByOrgId")
    String getSupervisorIdByOrgId(@RequestParam(value = "orgId",required = false) String orgId);

    /**
     * 获取组织树选择器
     **/
    @RequestMapping("/feign/sys/org/orgTreeSelector")
    String orgTreeSelector();

    /**
     * 获取组织列表选择器
     **/
    @RequestMapping("/feign/sys/org/orgListSelector")
    String orgListSelector(@RequestParam(value = "parentId",required = false) String parentId);

}
