package com.zch.sys.modular.user.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户职位信息结果
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysUserPositionResult {

    /** 组织id */
    @ApiModelProperty(value = "组织id", position = 1)
    private String orgId;

    /** 组织名称 */
    @ApiModelProperty(value = "组织名称", position = 2)
    private String orgName;

    /** 职位id */
    @ApiModelProperty(value = "职位id", position = 3)
    private String positionId;

    /** 职位名称 */
    @ApiModelProperty(value = "职位名称", position = 4)
    private String positionName;

    /** 组织分类 */
    @ApiModelProperty(value = "组织分类", position = 5)
    private String category;

    /** 职位类型 */
    @ApiModelProperty(value = "职位类型", position = 6)
    private String type;
}
