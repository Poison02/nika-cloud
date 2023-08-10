package com.zch.sys.modular.index.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 日程查询列表参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysIndexScheduleListParam {

    /** 日程日期 */
    @ApiModelProperty(value = "日程日期", required = true)
    @NotBlank(message = "scheduleDate不能为空")
    private String scheduleDate;
}
