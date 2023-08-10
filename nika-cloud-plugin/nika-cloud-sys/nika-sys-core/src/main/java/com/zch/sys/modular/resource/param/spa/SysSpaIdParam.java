package com.zch.sys.modular.resource.param.spa;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 单页面id参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysSpaIdParam {

    /** id */
    @ApiModelProperty(value = "id", required = true)
    @NotBlank(message = "id不能为空")
    private String id;
}
