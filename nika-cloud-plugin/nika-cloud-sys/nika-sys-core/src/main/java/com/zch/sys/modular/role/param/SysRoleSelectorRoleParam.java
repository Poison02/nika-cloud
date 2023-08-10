package com.zch.sys.modular.role.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 角色选择器参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysRoleSelectorRoleParam {

    /** 当前页 */
    @ApiModelProperty(value = "当前页码")
    private Integer current;

    /** 每页条数 */
    @ApiModelProperty(value = "每页条数")
    private Integer size;

    /** 组织id */
    @ApiModelProperty(value = "组织id")
    private String orgId;

    /** 角色分类 */
    @ApiModelProperty(value = "角色分类")
    private String category;

    /** 名称关键词 */
    @ApiModelProperty(value = "名称关键词")
    private String searchKey;

    /** 数据范围信息 */
    @ApiModelProperty(value = "数据范围信息")
    private List<String> dataScopeList;
}
