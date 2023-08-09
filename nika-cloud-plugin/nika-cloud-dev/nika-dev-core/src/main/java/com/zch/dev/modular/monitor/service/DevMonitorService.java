package com.zch.dev.modular.monitor.service;

import com.zch.dev.modular.monitor.result.DevMonitorServerResult;

/**
 * @author Zch
 * @date 2023/8/9
 **/
public interface DevMonitorService {

    /**
     * 获取服务器监控信息
     */
    DevMonitorServerResult serverInfo();

}
