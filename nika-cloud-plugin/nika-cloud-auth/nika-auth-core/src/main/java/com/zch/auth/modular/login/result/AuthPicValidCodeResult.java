package com.zch.auth.modular.login.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 图片验证码结果
 * @author Zch
 * @date 2023/8/6
 **/
@Getter
@Setter
public class AuthPicValidCodeResult {

    /** 验证码图片，Base64 */
    @ApiModelProperty(value = "验证码图片，Base64", position = 1)
    private String validCodeBase64;

    /** 验证码请求号 */
    @ApiModelProperty(value = "验证码请求号", position = 2)
    private String validCodeReqNo;

}
