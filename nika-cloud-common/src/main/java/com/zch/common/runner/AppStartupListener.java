package com.zch.common.runner;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.zch.common.consts.AppConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Date;

/**
 * 启动时的日志打印
 * @author Zch
 * @date 2023/8/5
 **/
@Slf4j
public class AppStartupListener implements ApplicationRunner {

    /**
     * 上下文管理器
     */
    @Resource
    private ApplicationContext ctx;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String appName = ctx.getEnvironment().getProperty("spring.application.name");;
        String appJvmName = ManagementFactory.getRuntimeMXBean().getName();;
        String appHost = InetAddress.getLocalHost().getHostAddress();
        String appPort = ctx.getEnvironment().getProperty("server.poret");
        String appPath = ctx.getEnvironment().getProperty("server.servlet.context-path");
        String appStartupDate = DateUtil.format(new Date(ctx.getStartupDate()), DatePattern.NORM_DATETIME_MS_PATTERN);
        log.info(AppConstant.APP_START_INFO,appName,appJvmName.split("@")[0],appStartupDate,appHost,appPort,(appPath==null?"":appPath));
    }
}
