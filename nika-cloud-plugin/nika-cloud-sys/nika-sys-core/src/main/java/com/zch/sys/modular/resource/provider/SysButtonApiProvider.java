package com.zch.sys.modular.resource.provider;

import com.zch.sys.api.SysButtonApi;
import com.zch.sys.modular.resource.service.SysButtonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Zch
 * @date 2023/8/10
 **/
@Service
public class SysButtonApiProvider implements SysButtonApi {

    @Resource
    private SysButtonService sysButtonService;

    @Override
    public void addForGenButton(String menuId, String className, String functionName) {
        sysButtonService.addForGenButton(menuId, className, functionName);
    }

}
