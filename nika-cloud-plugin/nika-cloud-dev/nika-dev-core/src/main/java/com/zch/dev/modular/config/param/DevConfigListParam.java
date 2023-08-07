package com.zch.dev.modular.config.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 配置 列表 参数
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
@Setter
public class DevConfigListParam {

    /** 配置分类 */
    @ApiModelProperty(value = "配置分类")
    private String category;
}
