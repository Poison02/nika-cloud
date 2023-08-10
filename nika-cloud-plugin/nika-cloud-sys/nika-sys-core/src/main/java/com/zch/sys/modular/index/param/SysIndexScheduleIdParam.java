package com.zch.sys.modular.index.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 日程id参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysIndexScheduleIdParam {

    /** 日程id */
    @ApiModelProperty(value = "id", required = true)
    @NotBlank(message = "id不能为空")
    private String id;
}
