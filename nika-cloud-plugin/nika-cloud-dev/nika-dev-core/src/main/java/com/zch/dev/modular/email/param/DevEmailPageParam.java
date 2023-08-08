package com.zch.dev.modular.email.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zch
 * @date 2023/8/8
 **/
@Getter
@Setter
public class DevEmailPageParam {

    /** 当前页 */
    @ApiModelProperty(value = "当前页码")
    private Integer current;

    /** 每页条数 */
    @ApiModelProperty(value = "每页条数")
    private Integer size;

    /** 排序字段 */
    @ApiModelProperty(value = "排序字段，字段驼峰名称，如：userName")
    private String sortField;

    /** 排序方式 */
    @ApiModelProperty(value = "排序方式，升序：ASCEND；降序：DESCEND")
    private String sortOrder;

    /** 邮件引擎 */
    @ApiModelProperty(value = "邮件引擎")
    private String engine;

    /** 邮件主题关键词 */
    @ApiModelProperty(value = "邮件主题关键词")
    private String searchKey;
}

