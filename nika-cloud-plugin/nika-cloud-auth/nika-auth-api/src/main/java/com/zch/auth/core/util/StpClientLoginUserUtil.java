package com.zch.auth.core.util;

import cn.hutool.core.collection.CollectionUtil;
import com.zch.auth.core.pojo.SaBaseClientLoginUser;

import java.util.List;

/**
 * C端登录用户工具类
 * @author Zch
 * @date 2023/8/6
 **/
public class StpClientLoginUserUtil {

    /**
     * 获取当前C端登录用户
     **/
    public static SaBaseClientLoginUser getClientLoginUser() {
        return (SaBaseClientLoginUser) StpClientUtil.getTokenSession().get("loginUser");
    }

    /**
     * 获取当前C端登录用户的当前请求接口的数据范围（暂无数据范围）
     **/
    public static List<String> getLoginUserDataScope() {
        return CollectionUtil.newArrayList();
    }

}
