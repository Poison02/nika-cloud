package com.zch.sys.modular.resource.provider;

import com.zch.sys.api.SysMenuApi;
import com.zch.sys.modular.resource.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Zch
 * @date 2023/8/10
 **/
@Service
public class SysMenuApiProvider implements SysMenuApi {

    @Resource
    private SysMenuService sysMenuService;

    @Override
    public String addForGenMenu(String parentId, String busName, String module, String title, String path) {
        return sysMenuService.addForGenMenu(parentId, busName, title, module, path);
    }
}
