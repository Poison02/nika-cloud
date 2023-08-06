package com.zch.sys.api;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 职位api
 * @author Zch
 * @date 2023/8/6
 **/
public interface SysPositionApi {

    /**
     * 根据职位id获取名称
     * @param positionId 职位id
     * @return
     */
    String getNameById(String positionId);

    /**
     * 根据组织id和搜索关键字获取职位选择器
     * @param orgId 组织id
     * @param searchKey 搜索关键字
     * @return
     */
    Page<JSONObject> positionSelector(String orgId, String searchKey);

}
