package com.zch.sys.modular.user.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 用户编辑个人工作台参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysUserUpdateWorkbenchParam {

    /** 工作台数据 */
    @ApiModelProperty(value = "工作台数据", required = true)
    @NotBlank(message = "workbenchData不能为空")
    private String workbenchData;
}
