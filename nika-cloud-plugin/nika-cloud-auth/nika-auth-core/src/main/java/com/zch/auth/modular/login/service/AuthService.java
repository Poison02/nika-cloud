package com.zch.auth.modular.login.service;

import com.zch.auth.core.pojo.SaBaseClientLoginUser;
import com.zch.auth.core.pojo.SaBaseLoginUser;
import com.zch.auth.modular.login.param.AuthAccountPasswordLoginParam;
import com.zch.auth.modular.login.param.AuthGetPhoneValidCodeParam;
import com.zch.auth.modular.login.param.AuthPhoneValidCodeLoginParam;
import com.zch.auth.modular.login.result.AuthPicValidCodeResult;

/**
 * 登录Service接口
 * @author Zch
 * @date 2023/8/6
 **/
public interface AuthService {

    /**
     * 获取图片验证码
     **/
    AuthPicValidCodeResult getPicCaptcha(String type);

    /**
     * 获取手机验证码
     **/
    String getPhoneValidCode(AuthGetPhoneValidCodeParam authGetPhoneValidCodeParam, String type);

    /**
     * 账号密码登录
     **/
    String doLogin(AuthAccountPasswordLoginParam authAccountPasswordLoginParam, String type);

    /**
     * 手机验证码登录
     **/
    String doLoginByPhone(AuthPhoneValidCodeLoginParam authPhoneValidCodeLoginParam, String type);

    /**
     * 获取B端登录用户信息
     **/
    SaBaseLoginUser getLoginUser();

    /**
     * 获取C端登录用户信息
     **/
    SaBaseClientLoginUser getClientLoginUser();

    /**
     * 根据用户id和客户端类型登录，用于第三方登录
     */
    String doLoginById(String userId, String device, String type);

}
