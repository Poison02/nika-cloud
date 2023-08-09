package com.zch.dev.modular.job.task;

import com.zch.common.timer.CommonTimerTaskRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 定时任务示例
 *
 * @author Zch
 * @date 2023/8/9
 **/
@Slf4j
@Component
public class DevJobTimerTaskRunner implements CommonTimerTaskRunner {

    private int n = 1;

    @Override
    public void action() {
        log.info("我是一个定时任务，正在执行第" + n + "次");
        n = n + 1;
    }
}
