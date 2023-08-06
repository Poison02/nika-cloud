package com.zch.sys.api;

/**
 * 菜单api
 * @author Zch
 * @date 2023/8/6
 **/
public interface SysMenuApi {

    /**
     * 代码生成菜单
     * @param parentId
     * @param busName
     * @param module
     * @param tile
     * @param path
     * @return
     */
    String addForGenMenu(String parentId, String busName, String module, String tile, String path);

}
