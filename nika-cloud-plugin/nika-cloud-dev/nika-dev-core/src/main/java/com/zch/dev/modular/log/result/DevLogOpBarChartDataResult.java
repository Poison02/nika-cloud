package com.zch.dev.modular.log.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 操作日志柱状图数据结果
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
@Setter
public class DevLogOpBarChartDataResult {

    @ApiModelProperty(value = "日期", position = 1)
    private String date;

    @ApiModelProperty(value = "名称", position = 2)
    private String name;

    @ApiModelProperty(value = "数量", position = 3)
    private Long count;

}
