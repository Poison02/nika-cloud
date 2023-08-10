package com.zch.auth.modular.sso.param;

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
public class AuthSsoTicketLoginParam {

    /** ticket */
    @ApiModelProperty(value = "ticket", required = true, position = 1)
    @NotBlank(message = "ticket不能为空")
    private String ticket;

    /** 设备 */
    @ApiModelProperty(value = "设备", position = 2)
    private String device;
}
