package com.zch.auth.core.util;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.zch.auth.core.pojo.SaBaseLoginUser;
import com.zch.util.CommonServletUtil;

import java.util.List;

/**
 * B端登录用户工具类
 * @author Zch
 * @date 2023/8/6
 **/
public class StpLoginUserUtil {

    /**
     * 获取B端登录用户
     * @return
     */
    public static SaBaseLoginUser getLoginUser() {
        return (SaBaseLoginUser) StpUtil.getTokenSession().get("loginUser");
    }

    /**
     * 获取当前B端登录用户的当前请求接口的数据范围
     * @return
     */
    public static List<String> getLoginUserDataScope() {
        List<String> resultList = CollectionUtil.newArrayList();
        getLoginUser().getDataScopeList().forEach(dataScope -> {
            if (dataScope.getApiUrl().equals(CommonServletUtil.getRequest().getServletPath())) {
                resultList.addAll(dataScope.getDataScope());
            }
        });
        return resultList;
    }

}
