package com.zch.auth.modular.monitor.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class AuthExitSessionParam {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", required = true)
    @NotBlank(message = "userId不能为空")
    private String userId;
}
