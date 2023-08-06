package com.zch.sys.api;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 角色api
 * @author Zch
 * @date 2023/8/6
 **/
public interface SysRoleApi {

    /**
     * 根据角色id列表判断组织下是都存在角色
     * @param orgIdList
     * @return
     */
    boolean orgHasRole(List<String> orgIdList);

    /**
     * 获取角色选择器
     * @param orgId
     * @param category
     * @param searchKey
     * @param dataScopeList
     * @return
     */
    Page<JSONObject> roleSelector(String orgId, String category, String searchKey, List<String> dataScopeList);

    /**
     * 代码生成菜单、按钮 授权
     * @param menuId
     */
    void grantForGenMenuAndButton(String menuId);

}
