package com.zch.sys.modular.user.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 用户id集合参数
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
@Setter
public class SysUserIdListParam {

    /** id集合 */
    @ApiModelProperty(value = "id集合", required = true)
    @NotNull(message = "idList不能为空")
    private List<String> idList;
}
