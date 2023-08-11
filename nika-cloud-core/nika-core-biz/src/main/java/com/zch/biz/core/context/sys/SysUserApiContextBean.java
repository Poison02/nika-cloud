package com.zch.biz.core.context.sys;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zch.sys.api.SysUserApi;
import com.zch.sys.feign.SysUserFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@Slf4j
@RequiredArgsConstructor
@Component
public class SysUserApiContextBean implements SysUserApi {

    private final SysUserFeign sysUserFeign;

    /**
     * 根据用户id获取用户对象，没有则返回null
     */
    @Override
    public JSONObject getUserByIdWithoutException(String userId) {
        String feignResp = sysUserFeign.getUserByIdWithoutException(userId);
        JSONObject resp = JSONUtil.parseObj(feignResp);
        return resp;
    }

    /**
     * 根据用户id获取用户对象列表，没有的则为空，都没有则返回空集合
     */
    @Override
    public List<JSONObject> getUserListByIdListWithoutException(List<String> userIdList) {
        String feignResp = sysUserFeign.getUserListByIdListWithoutException(userIdList);
        JSONArray jsonArray = new JSONArray(feignResp);
        List<JSONObject> resp = jsonArray.toList(JSONObject.class);
        return resp;
    }

    /**
     * 根据用户id获取用户对象，没有则抛出异常
     */
    @Override
    public JSONObject getUserByIdWithException(String userId) {
        String feignResp = sysUserFeign.getUserByIdWithoutException(userId);
        JSONObject resp = JSONUtil.parseObj(feignResp);
        return resp;
    }

    /**
     * 根据用户id获取用户对象列表，只要有一个没有则抛出异常
     */
    @Override
    public List<JSONObject> getUserListByIdWithException(List<String> userIdList) {
        String feignResp = sysUserFeign.getUserListByIdWithException(userIdList);
        JSONArray jsonArray = new JSONArray(feignResp);
        List<JSONObject> resp = jsonArray.toList(JSONObject.class);
        return resp;
    }

    /**
     * 获取用户拥有角色
     */
    @Override
    public List<String> ownRole(String userId) {
        String feignResp = sysUserFeign.ownRole(userId);
        JSONArray jsonArray = new JSONArray(feignResp);
        List<String> resp = jsonArray.toList(String.class);
        return resp;
    }

    /**
     * 给用户授权角色
     */
    @Override
    public void grantRole(String userId, List<String> roleIdList) {
        sysUserFeign.grantRole(userId, roleIdList);
    }

    /**
     * 根据组织id集合获取组织下用户id集合
     */
    @Override
    public List<String> getUserIdListByOrgIdList(List<String> orgIdList) {
        String feignResp = sysUserFeign.getUserIdListByOrgIdList(orgIdList);
        JSONArray jsonArray = new JSONArray(feignResp);
        List<String> resp = jsonArray.toList(String.class);
        return resp;
    }

    /**
     * 根据职位id集合获取职位下用户id集合
     */
    @Override
    public List<String> getUserIdListByPositionIdList(List<String> positionIdList) {
        String feignResp = sysUserFeign.getUserIdListByPositionIdList(positionIdList);
        JSONArray jsonArray = new JSONArray(feignResp);
        List<String> resp = jsonArray.toList(String.class);
        return resp;
    }

    /**
     * 根据用户id和组织id和职位id获取上级主管id
     */
    @Override
    public String getSupervisorIdByUserIdAndOrgIdAndPositionId(String userId, String orgId, String positionId) {
        return sysUserFeign.getSupervisorIdByUserIdAndOrgIdAndPositionId(userId, orgId, positionId);
    }

    /**
     * 获取用户选择器
     */
    @Override
    public Page<JSONObject> userSelector(String orgId, String searchKey) {
        String feignResp = sysUserFeign.userSelector(orgId, searchKey);
        Page<JSONObject> resp =  (Page<JSONObject>)JSONUtil.toBean(feignResp,Page.class);
        return resp;
    }
}
