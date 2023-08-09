package com.zch.dev.modular.job.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zch.dev.modular.job.entity.DevJob;
import com.zch.dev.modular.job.param.*;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/9
 **/
public interface DevJobService extends IService<DevJob> {

    /**
     * 获取定时任务分页
     * @param devJobPageParam
     * @return
     */
    Page<DevJob> page(DevJobPageParam devJobPageParam);

    /**
     * 获取定时任务列表
     * @param devJobListParam
     * @return
     */
    List<DevJob> list(DevJobListParam devJobListParam);

    /**
     * 添加定时任务
     * @param devJobAddParam
     */
    void add(DevJobAddParam devJobAddParam);

    /**
     * 编辑定时任务
     * @param devJobEditParam
     */
    void edit(DevJobEditParam devJobEditParam);

    /**
     * 删除定时任务
     * @param devJobIdParamList
     */
    void delete(List<DevJobIdParam> devJobIdParamList);

    /**
     * 获取定时任务详情
     * @param devJobIdParam
     * @return
     */
    DevJob detail(DevJobIdParam devJobIdParam);

    /**
     * 获取定时任务详情
     * @param id
     * @return
     */
    DevJob queryEntity(String id);

    /**
     * 停止定时任务
     * @param devJobIdParam
     */
    void stopJob(DevJobIdParam devJobIdParam);

    /**
     * 运行定时任务
     * @param devJobIdParam
     */
    void runJob(DevJobIdParam devJobIdParam);

    /**
     * 立即运行定时任务
     * @param devJobIdParam
     */
    void runJobNow(DevJobIdParam devJobIdParam);

    /**
     * 获取定时任务类
     * @return
     */
    List<String> getActionClass();

}
