package com.zch.auth.modular.monitor.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class AuthSessionPageParam {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

}
