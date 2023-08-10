package com.zch.auth.modular.sso.service.impl;

import com.zch.auth.modular.sso.param.AuthSsoTicketLoginParam;
import com.zch.auth.modular.sso.service.AuthSsoService;
import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/8/10
 **/
@Service
public class AuthSsoServiceImpl implements AuthSsoService {
    @Override
    public String doLogin(AuthSsoTicketLoginParam authAccountPasswordLoginParam, String value) {
        return null;
    }
}
