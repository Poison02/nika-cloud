package com.zch.sys.modular.position.enums;

import com.zch.common.exception.CommonException;
import lombok.Getter;

/**
 * 职位分类枚举
 * @author Zch
 * @date 2023/8/10
 **/
@Getter
public enum SysPositionCategoryEnum {

    /** 高层 */
    HIGH("HIGH"),

    /** 中层 */
    MIDDLE("MIDDLE"),

    /** 基层 */
    LOW("LOW");

    private final String value;

    SysPositionCategoryEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = HIGH.getValue().equals(value) || MIDDLE.getValue().equals(value) || LOW.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的职位分类：{}", value);
        }
    }
}
