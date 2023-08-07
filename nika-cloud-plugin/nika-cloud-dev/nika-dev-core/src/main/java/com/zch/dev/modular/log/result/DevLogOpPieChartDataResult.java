package com.zch.dev.modular.log.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 操作日志饼状图数据结果
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
@Setter
public class DevLogOpPieChartDataResult {

    @ApiModelProperty(value = "类型", position = 1)
    private String type;

    @ApiModelProperty(value = "数量", position = 2)
    private Long value;

}
