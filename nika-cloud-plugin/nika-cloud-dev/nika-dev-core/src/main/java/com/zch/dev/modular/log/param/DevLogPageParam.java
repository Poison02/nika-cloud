package com.zch.dev.modular.log.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 日志查询参数
 * @author Zch
 * @date 2023/8/7
 **/
@Getter
@Setter
public class DevLogPageParam {

    @ApiModelProperty(value = "当前页码")
    private Integer current;

    @ApiModelProperty(value = "每页条数")
    private Integer size;

    @ApiModelProperty(value = "排序字段，字段驼峰名称，如：userName")
    private String sortField;

    @ApiModelProperty(value = "排序方式，升序：ASCEND；降序：DESCEND")
    private String sortOrder;

    @ApiModelProperty(value = "日志分类")
    private String category;

    @ApiModelProperty(value = "日志名称关键字")
    private String searchKey;

}
