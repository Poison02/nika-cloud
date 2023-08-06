package com.zch.auth.core.pojo;

import com.zch.auth.core.enums.SysUserStatusEnum;

/**
 * 登录用户对象
 * @author Zch
 * @date 2023/8/6
 **/
public class SysLoginUser extends SaBaseLoginUser{

    /**
     * 是否可以登录
     * @return
     */
    @Override
    public Boolean getEnabled() {
        return getUserStatus().equals(SysUserStatusEnum.ENABLE.getValue());
    }
}
