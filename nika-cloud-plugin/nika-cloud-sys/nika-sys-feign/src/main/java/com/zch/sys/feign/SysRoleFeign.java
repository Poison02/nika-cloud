package com.zch.sys.feign;

import com.zch.common.consts.FeignConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@FeignClient(name= FeignConstant.WEB_APP, contextId = "SysRoleFeign")
public interface SysRoleFeign {

    /**
     * 判断组织下是否存在角色
     */
    @RequestMapping("/feign/sys/role/orgHasRole")
    boolean orgHasRole(@RequestParam(value = "orgIdList",required = false) List<String> orgIdList);

    /**
     * 获取角色选择器
     **/
    @RequestMapping("/feign/sys/role/roleSelector")
    String roleSelector(@RequestParam(value = "orgId",required = false) String orgId, @RequestParam(value = "category",required = false) String category, @RequestParam(value = "searchKey",required = false) String searchKey,@RequestParam(value = "dataScopeList",required = false)  List<String> dataScopeList);

    /**
     * 代码生成菜单按钮授权
     **/
    @RequestMapping("/feign/sys/role/grantForGenMenuAndButton")
    void grantForGenMenuAndButton(@RequestParam(value = "menuId",required = false) String menuId);

}
