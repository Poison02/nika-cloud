package com.zch.sys.modular.resource.param.menu;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 菜单模块选择器参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysMenuSelectorModuleParam {

    /** 名称关键词 */
    @ApiModelProperty(value = "名称关键词")
    private String searchKey;
}
