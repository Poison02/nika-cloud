package com.zch.timer;

/**
 * 定时器执行器，定时器都要实现本接口，并需要把实现类加入到spring容器中
 * @author Zch
 * @date 2023/8/5
 **/
public interface CommonTimerTaskRunner {

    /**
     * 任务执行的具体内容
     */
    void action();

}
