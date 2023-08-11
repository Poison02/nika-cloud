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
@FeignClient(name= FeignConstant.WEB_APP, contextId = "SysUserFeign")
public interface SysUserFeign {

    /**
     * 根据用户id获取用户对象，没有则返回null
     **/
    @RequestMapping("/feign/sys/user/getUserByIdWithoutException")
    String getUserByIdWithoutException(@RequestParam(value = "userId",required = false) String userId);

    /**
     * 根据用户id获取用户对象列表，没有的则为空，都没有则返回空集合
     **/
    @RequestMapping("/feign/sys/user/getUserListByIdListWithoutException")
    String getUserListByIdListWithoutException(@RequestParam(value = "userIdList",required = false) List<String> userIdList);

    /**
     * 根据用户id获取用户对象，没有则抛出异常
     **/
    @RequestMapping("/feign/sys/user/getUserByIdWithException")
    String getUserByIdWithException(@RequestParam(value = "userId",required = false) String userId);

    /**
     * 根据用户id获取用户对象列表，只要有一个没有则抛出异常
     **/
    @RequestMapping("/feign/sys/user/getUserListByIdWithException")
    String getUserListByIdWithException(@RequestParam(value = "userIdList",required = false) List<String> userIdList);

    /**
     * 获取用户拥有角色
     */
    @RequestMapping("/feign/sys/user/ownRole")
    String ownRole(@RequestParam(value = "userId",required = false) String userId);

    /**
     * 给用户授权角色
     */
    @RequestMapping("/feign/sys/user/grantRole")
    void grantRole(@RequestParam(value = "userId",required = false) String userId, @RequestParam(value = "roleIdList",required = false) List<String> roleIdList);

    /**
     * 根据组织id集合获取组织下用户id集合
     **/
    @RequestMapping("/feign/sys/user/getUserIdListByOrgIdList")
    String getUserIdListByOrgIdList(@RequestParam(value = "orgIdList",required = false) List<String> orgIdList);

    /**
     * 根据职位id集合获取职位下用户id集合
     **/
    @RequestMapping("/feign/sys/user/getUserIdListByPositionIdList")
    String getUserIdListByPositionIdList(@RequestParam(value = "positionIdList",required = false) List<String> positionIdList);

    /**
     * 根据用户id和组织id和职位id获取上级主管id
     **/
    @RequestMapping("/feign/sys/user/getSupervisorIdByUserIdAndOrgIdAndPositionId")
    String getSupervisorIdByUserIdAndOrgIdAndPositionId(@RequestParam(value = "userId",required = false) String userId, @RequestParam(value = "orgId",required = false) String orgId, @RequestParam(value = "positionId",required = false) String positionId);

    /**
     * 获取用户选择器
     */
    @RequestMapping("/feign/sys/user/userSelector")
    String userSelector(@RequestParam("orgId") String orgId, @RequestParam("searchKey") String searchKey);

}
