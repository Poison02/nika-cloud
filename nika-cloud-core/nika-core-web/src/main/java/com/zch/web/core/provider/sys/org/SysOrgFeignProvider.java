package com.zch.web.core.provider.sys.org;

import cn.hutool.json.JSONUtil;
import com.zch.sys.feign.SysOrgFeign;
import com.zch.sys.modular.org.provider.SysOrgApiProvider;
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
public class SysOrgFeignProvider implements SysOrgFeign {

    private final SysOrgApiProvider sysOrgApiProvider;

    /**
     * 根据id获取名称
     */
    @Override
    @RequestMapping("/feign/sys/org/getNameById")
    public String getNameById(@RequestParam(value = "orgId",required = false) String orgId) {
        return sysOrgApiProvider.getNameById(orgId);
    }

    /**
     * 根据组织id获取部门主管id
     */
    @Override
    @RequestMapping("/feign/sys/org/getSupervisorIdByOrgId")
    public String getSupervisorIdByOrgId(@RequestParam(value = "orgId",required = false) String orgId) {
        return sysOrgApiProvider.getSupervisorIdByOrgId(orgId);
    }

    /**
     * 获取组织树选择器
     **/
    @Override
    @RequestMapping("/feign/sys/org/orgTreeSelector")
    public String orgTreeSelector() {
        return JSONUtil.toJsonStr(sysOrgApiProvider.orgTreeSelector());
    }

    /**
     * 获取组织列表选择器
     */
    @Override
    @RequestMapping("/feign/sys/org/orgListSelector")
    public String orgListSelector(@RequestParam(value = "parentId",required = false) String parentId) {
        return JSONUtil.toJsonStr(sysOrgApiProvider.orgListSelector(parentId));
    }
}
