package com.zch.sys.api;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 组织id
 * @author Zch
 * @date 2023/8/6
 **/
public interface SysOrgApi {

    /**
     * 根据id获取组织名称
     * @param orgId 组织id
     * @return
     */
    String getNameById(String orgId);

    /**
     * 根据组织id获取主管id
     * @param orgId
     * @return
     */
    String getSupervisorIdByOrgId(String orgId);

    /**
     * 获取组织树选择器
     * @return
     */
    List<Tree<String>> orgTreeSelector();

    /**
     * 获取组织列表选择器
     * @param parentId
     * @return
     */
    Page<JSONObject> orgListSelector(String parentId);

}
