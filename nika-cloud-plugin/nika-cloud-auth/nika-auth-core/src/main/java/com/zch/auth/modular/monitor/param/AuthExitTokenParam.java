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
public class AuthExitTokenParam {

    /**
     * token值
     */
    @ApiModelProperty(value = "token值", required = true)
    @NotBlank(message = "tokenValue不能为空")
    private String tokenValue;
}
