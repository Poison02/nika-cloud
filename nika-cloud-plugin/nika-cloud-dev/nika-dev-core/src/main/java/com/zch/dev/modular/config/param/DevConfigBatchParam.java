package com.zch.dev.modular.config.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 配置 批量更新 参数
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
@Setter
public class DevConfigBatchParam {

    /** 配置键 */
    @ApiModelProperty(value = "配置键", required = true, position = 1)
    @NotBlank(message = "configKey不能为空")
    private String configKey;

    /** 配置值 */
    @ApiModelProperty(value = "配置值", required = true, position = 2)
    @NotBlank(message = "configValue不能为空")
    private String configValue;

}
