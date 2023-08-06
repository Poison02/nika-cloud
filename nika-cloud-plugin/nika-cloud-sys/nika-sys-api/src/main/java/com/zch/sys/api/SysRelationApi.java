package com.zch.sys.api;

import java.util.List;

/**
 * 关系api
 * @author Zch
 * @date 2023/8/6
 **/
public interface SysRelationApi {

    List<String> getUserIdListByRoleIdList(List<String> roleIdList);

    /**
     * 根据移动端菜单id集合移除角色和移动端菜单关系
     * @param targetIdList
     */
    void removeRoleHasMobileMenuRelation(List<String> targetIdList);

    /**
     * 清除相应的角色与移动端菜单信息中的【授权的移动端按钮信息】
     * @param targetIdList
     * @param buttonIdList
     */
    void removeRoleHasMobileButtonRelation(List<String> targetIdList, List<String> buttonIdList);

}
