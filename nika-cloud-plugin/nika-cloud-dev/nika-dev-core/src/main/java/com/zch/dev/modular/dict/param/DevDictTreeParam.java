package com.zch.dev.modular.dict.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zch
 * @date 2023/8/8
 **/
@Getter
@Setter
public class DevDictTreeParam {

    /** 字典分类 */
    @ApiModelProperty(value = "字典分类")
    private String category;
}
