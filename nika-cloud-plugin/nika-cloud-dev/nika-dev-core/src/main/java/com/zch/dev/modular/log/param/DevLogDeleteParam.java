package com.zch.dev.modular.log.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 日志清空参数
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
@Setter
public class DevLogDeleteParam {

    @ApiModelProperty(value = "日志分类", required = true)
    @NotBlank(message = "category不能为空")
    private String category;

}
