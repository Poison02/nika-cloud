package com.zch.dev.modular.log.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zch.dev.modular.log.entity.DevLog;
import com.zch.dev.modular.log.param.DevLogDeleteParam;
import com.zch.dev.modular.log.param.DevLogPageParam;
import com.zch.dev.modular.log.result.DevLogOpBarChartDataResult;
import com.zch.dev.modular.log.result.DevLogOpPieChartDataResult;
import com.zch.dev.modular.log.result.DevLogVisLineChartDataResult;
import com.zch.dev.modular.log.result.DevLogVisPieChartDataResult;

import java.util.List;

/**
 * 日志service
 * @author Zch
 * @date 2023/8/7
 **/
public interface DevLogService extends IService<DevLog> {

    /**
     * 获取日志分页
     * @param devLogPageParam
     * @return
     */
    Page<DevLog> page(DevLogPageParam devLogPageParam);

    /**
     * 清空日志
     * @param devLogDeleteParam
     */
    void delete(DevLogDeleteParam devLogDeleteParam);

    /**
     * 获取访问日志折线图数据
     */
    List<DevLogVisLineChartDataResult> visLogLineChartData();

    /**
     * 获取访问日志饼状图数据
     */
    List<DevLogVisPieChartDataResult> visLogPieChartData();

    /**
     * 获取操作日志柱状图数据
     */
    List<DevLogOpBarChartDataResult> opLogBarChartData();

    /**
     * 获取操作日志饼状图数据
     */
    List<DevLogOpPieChartDataResult> opLogPieChartData();

}
