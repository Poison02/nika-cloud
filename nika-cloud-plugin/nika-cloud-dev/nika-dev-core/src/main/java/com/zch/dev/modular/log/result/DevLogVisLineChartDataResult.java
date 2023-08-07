package com.zch.dev.modular.log.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 访问日志折线图数据结果
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
@Setter
public class DevLogVisLineChartDataResult {

    @ApiModelProperty(value = "日期", position = 1)
    private String date;

    @ApiModelProperty(value = "登录数量", position = 2)
    private Long loginCount;

    @ApiModelProperty(value = "登出数量", position = 3)
    private Long logoutCount;

}
