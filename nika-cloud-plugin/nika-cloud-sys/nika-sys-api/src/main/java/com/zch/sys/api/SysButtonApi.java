package com.zch.sys.api;

/**
 * 按钮api
 * @author Zch
 * @date 2023/8/6
 **/
public interface SysButtonApi {

    /**
     * 代码生成按钮
     * @param menuId 菜单id
     * @param className 类名
     * @param functionName 函数名
     */
    void addForGenButton(String menuId, String className, String functionName);

}
