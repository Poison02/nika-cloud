package com.zch.dev.modular.job.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zch
 * @date 2023/8/9
 **/
@Getter
@Setter
public class DevJobListParam {

    /** 任务分类 */
    @ApiModelProperty(value = "任务分类")
    private String category;

    /** 名称关键词 */
    @ApiModelProperty(value = "名称关键词")
    private String searchKey;

    /** 任务状态 */
    @ApiModelProperty(value = "任务状态")
    private String jobStatus;
}
