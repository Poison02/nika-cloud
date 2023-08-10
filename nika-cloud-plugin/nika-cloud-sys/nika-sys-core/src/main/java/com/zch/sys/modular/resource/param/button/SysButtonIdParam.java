package com.zch.sys.modular.resource.param.button;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 按钮 id 参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysButtonIdParam {

    /** id */
    @ApiModelProperty(value = "id", required = true)
    @NotBlank(message = "id不能为空")
    private String id;
}
