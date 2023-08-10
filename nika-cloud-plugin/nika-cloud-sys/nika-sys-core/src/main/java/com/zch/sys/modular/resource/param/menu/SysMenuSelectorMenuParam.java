package com.zch.sys.modular.resource.param.menu;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 菜单选择器参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysMenuSelectorMenuParam {

    /** 模块 */
    @ApiModelProperty(value = "模块")
    private String module;
}
