package com.zch.web.core.provider.sys.user;

import cn.hutool.json.JSONUtil;
import com.zch.sys.feign.SysUserFeign;
import com.zch.sys.modular.user.provider.SysUserApiProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@Slf4j
@RequiredArgsConstructor
@RestController
public class SysUserFeignProvider implements SysUserFeign {

    private final SysUserApiProvider sysUserApiProvider;

    /**
     * 根据用户id获取用户对象，没有则返回null
     */
    @Override
    @RequestMapping("/feign/sys/user/getUserByIdWithoutException")
    public String getUserByIdWithoutException(@RequestParam(value = "userId",required = false) String userId) {
        return JSONUtil.toJsonStr(sysUserApiProvider.getUserByIdWithoutException(userId));
    }

    /**
     * 根据用户id获取用户对象列表，没有的则为空，都没有则返回空集合
     */
    @Override
    @RequestMapping("/feign/sys/user/getUserListByIdListWithoutException")
    public String getUserListByIdListWithoutException(@RequestParam(value = "userIdList",required = false) List<String> userIdList) {
        return JSONUtil.toJsonStr(sysUserApiProvider.getUserListByIdListWithoutException(userIdList));
    }

    /**
     * 根据用户id获取用户对象，没有则抛出异常
     */
    @Override
    @RequestMapping("/feign/sys/user/getUserByIdWithException")
    public String getUserByIdWithException(@RequestParam(value = "userId",required = false) String userId) {
        return JSONUtil.toJsonStr(sysUserApiProvider.getUserByIdWithException(userId));
    }

    /**
     * 根据用户id获取用户对象列表，只要有一个没有则抛出异常
     */
    @Override
    @RequestMapping("/feign/sys/user/getUserListByIdWithException")
    public String getUserListByIdWithException(@RequestParam(value = "userIdList",required = false) List<String> userIdList) {
        return JSONUtil.toJsonStr(sysUserApiProvider.getUserListByIdWithException(userIdList));
    }

    /**
     * 获取用户拥有角色
     */
    @Override
    @RequestMapping("/feign/sys/user/ownRole")
    public String ownRole(@RequestParam(value = "userId",required = false) String userId) {
        return JSONUtil.toJsonStr(sysUserApiProvider.ownRole(userId));
    }

    /**
     * 给用户授权角色
     */
    @Override
    @RequestMapping("/feign/sys/user/grantRole")
    public void grantRole(@RequestParam(value = "userId",required = false) String userId, @RequestParam(value = "roleIdList",required = false) List<String> roleIdList) {
        sysUserApiProvider.grantRole(userId, roleIdList);
    }

    /**
     * 根据组织id集合获取组织下用户id集合
     */
    @Override
    @RequestMapping("/feign/sys/user/getUserIdListByOrgIdList")
    public String getUserIdListByOrgIdList(@RequestParam(value = "orgIdList",required = false) List<String> orgIdList) {
        return JSONUtil.toJsonStr(sysUserApiProvider.getUserIdListByOrgIdList(orgIdList));
    }

    /**
     * 根据职位id集合获取职位下用户id集合
     */
    @Override
    @RequestMapping("/feign/sys/user/getUserIdListByPositionIdList")
    public String getUserIdListByPositionIdList(@RequestParam(value = "positionIdList",required = false) List<String> positionIdList) {
        return JSONUtil.toJsonStr(sysUserApiProvider.getUserIdListByPositionIdList(positionIdList));
    }

    /**
     * 根据用户id和组织id和职位id获取上级主管id
     */
    @Override
    @RequestMapping("/feign/sys/user/getSupervisorIdByUserIdAndOrgIdAndPositionId")
    public String getSupervisorIdByUserIdAndOrgIdAndPositionId(@RequestParam(value = "userId",required = false) String userId, @RequestParam(value = "orgId",required = false) String orgId, @RequestParam(value = "positionId",required = false) String positionId) {
        return sysUserApiProvider.getSupervisorIdByUserIdAndOrgIdAndPositionId(userId, orgId, positionId);
    }

    /**
     * 获取用户选择器
     */
    @Override
    @RequestMapping("/feign/sys/user/userSelector")
    public String userSelector(@RequestParam(value = "orgId",required = false) String orgId, @RequestParam(value = "searchKey",required = false) String searchKey) {
        return JSONUtil.toJsonStr(sysUserApiProvider.userSelector(orgId, searchKey));
    }
}
