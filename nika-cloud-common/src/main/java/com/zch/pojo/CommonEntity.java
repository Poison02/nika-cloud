package com.zch.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用基础字段实体，创建时间、创建人、修改时间、修改人，
 * 继承此类要求数据表有对应的字段
 * @author Zch
 * @date 2023/8/5
 **/
@Getter
@Setter
public class CommonEntity implements Serializable {

    /**
     * 删除标志
     * 逻辑删除
     */
    @TableLogic
    @ApiModelProperty(value = "删除标志", position = 999)
    @TableField(fill = FieldFill.INSERT)
    private String deleteFlag;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", position = 1000)
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", position = 1001)
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", position = 1002)
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人", position = 1003)
    @TableField(fill = FieldFill.UPDATE)
    private String updateUser;

}
