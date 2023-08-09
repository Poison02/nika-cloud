package com.zch.dev.core.listener;

import cn.hutool.cron.CronUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zch.common.exception.CommonException;
import com.zch.common.timer.CommonTimerTaskRunner;
import com.zch.dev.modular.job.entity.DevJob;
import com.zch.dev.modular.job.enums.DevJobStatusEnum;
import com.zch.dev.modular.job.service.DevJobService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author Zch
 * @date 2023/8/9
 **/
@Slf4j
@Configuration
public class DevJobListener implements ApplicationListener<ApplicationStartedEvent>, Ordered {
    @Override
    public void onApplicationEvent(@NotNull ApplicationStartedEvent event) {
        SpringUtil.getBean(DevJobService.class).list(new LambdaQueryWrapper<DevJob>()
                .eq(DevJob::getJobStatus, DevJobStatusEnum.RUNNING.getValue())
                .orderByAsc(DevJob::getSortCode))
                .forEach(devJob -> CronUtil.schedule(devJob.getId(), devJob.getCronExpression(), () -> {
                    try {
                        // 运行定时任务
                        ((CommonTimerTaskRunner) SpringUtil.getBean(Class.forName(devJob.getActionClass()))).action();
                    } catch (ClassNotFoundException e) {
                        throw new CommonException("定时任务找不到对应的类，名册为：{}", devJob.getActionClass());
                    }
                }));
        // 设置秒级别的启用
        CronUtil.setMatchSecond(true);
        // 启动定时器执行器
        CronUtil.start();
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
