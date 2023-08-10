package com.zch.sys.modular.index.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 站内信 列表 参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysIndexMessageListParam {

    /** 条数" */
    @ApiModelProperty(value = "条数")
    private Integer limit;
}
