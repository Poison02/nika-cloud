package com.zch.dev.modular.file.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zch
 * @date 2023/8/8
 **/
@Getter
@Setter
public class DevFileListParam {

    /** 文件引擎 */
    @ApiModelProperty(value = "文件引擎")
    private String engine;

    /** 文件名关键词 */
    @ApiModelProperty(value = "文件名关键词")
    private String searchKey;
}
