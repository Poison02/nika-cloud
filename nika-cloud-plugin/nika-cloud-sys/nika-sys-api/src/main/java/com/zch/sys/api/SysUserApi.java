package com.zch.sys.api;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 用户api
 * @author Zch
 * @date 2023/8/6
 **/
public interface SysUserApi {

    /**
     * 根据用户id获取用户对象，没有则返回null
     * @param userId 用户id
     * @return
     */
    JSONObject getUserByIdWithoutException(String userId);

    /**
     * 根据用户id获取用户对象列表，没有的话则为空，都没有则返回空集合
     * @param userIdList 用户id列表
     * @return
     */
    List<JSONObject> getUserListByIdListWithoutException(List<String> userIdList);

    /**
     * 根据用户id获取用户对象，没有则抛出异常
     * @param userId 用户id
     * @return JSONObject
     */
    JSONObject getUserByIdWithException(String userId);

    /**
     * 根据用户id获取用户对象列表，只要有一个没有则抛出异常
     * @param userIdList 用户id列表
     * @return List<JSONObject>
     */
    List<JSONObject> getUserListByIdWithException(List<String> userIdList);

    /**
     * 获取用户拥有角色
     * @param userId 用户id
     * @return List<String>
     */
    List<String> ownRole(String userId);

    /**
     * 给用户授权角色
     * @param userId 用户id
     * @param roleIdList 角色id列表
     */
    void grantRole(String userId, List<String> roleIdList);

    /**
     * 根据组织id集合获取组织下用户id集合
     * @param orgIdList 组织id列表
     * @return List<String>
     */
    List<String> getUserIdListByOrgIdList(List<String> orgIdList);

    /**
     * 根据职位id集合获取职位下用户id集合
     * @param positionIdList 职位id列表
     * @return List<String>
     */
    List<String> getUserIdListByPositionIdList(List<String> positionIdList);

    /**
     * 根据用户id、组织id、职位id获取上级主管id
     * @param userId 用户id
     * @param orgId 组织id
     * @param positionId 职位id
     * @return String
     */
    String getSupervisorIdByUserIdAndOrgIdAndPositionId(String userId, String orgId, String positionId);

    /**
     * 获取用户选择器
     * @param orgId 组织id
     * @param searchKey 搜索关键字
     * @return Page<JSONObject>
     */
    Page<JSONObject> userSelector(String orgId, String searchKey);

}
