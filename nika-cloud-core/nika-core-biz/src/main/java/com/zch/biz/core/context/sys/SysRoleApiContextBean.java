package com.zch.biz.core.context.sys;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.zch.sys.api.SysRoleApi;
import com.zch.sys.feign.SysRoleFeign;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@Slf4j
@RequiredArgsConstructor
@Component
public class SysRoleApiContextBean implements SysRoleApi {

    private final SysRoleFeign sysRoleFeign;

    /**
     * 判断组织下是否存在角色
     */
    @Override
    public boolean orgHasRole(List<String> orgIdList) {
        return sysRoleFeign.orgHasRole(orgIdList);
    }

    /**
     * 获取角色选择器
     */
    @SuppressWarnings("ALL")
    @Override
    public Page<JSONObject> roleSelector(String orgId, String category, String searchKey, List<String> dataScopeList) {
        String feignResp = sysRoleFeign.roleSelector(orgId, category, searchKey, dataScopeList);
        Page<JSONObject> resp =  (Page<JSONObject>) JSONUtil.toBean(feignResp,Page.class);
        return resp;
    }

    /**
     * 代码生成菜单按钮授权
     */
    @Override
    public void grantForGenMenuAndButton(String menuId) {
        sysRoleFeign.grantForGenMenuAndButton(menuId);
    }
}
