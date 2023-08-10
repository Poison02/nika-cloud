package com.zch.auth.modular.sso.service;

import com.zch.auth.modular.sso.param.AuthSsoTicketLoginParam;

/**
 * @author Zch
 * @date 2023/8/10
 **/
public interface AuthSsoService {

    /**
     * 根据ticket执行单点登录
     **/
    String doLogin(AuthSsoTicketLoginParam authAccountPasswordLoginParam, String value);

}
