package com.zch.sys.modular.index.service;

import com.zch.common.pojo.CommonValidList;
import com.zch.sys.modular.index.param.*;
import com.zch.sys.modular.index.result.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/10
 **/
public interface SysIndexService {

    /**
     * 添加当前用户日程
     */
    void addSchedule(SysIndexScheduleAddParam sysIndexScheduleAddParam);

    /**
     * 删除日程
     */
    void deleteSchedule(CommonValidList<SysIndexScheduleIdParam> sysIndexScheduleIdParamList);

    /**
     * 获取当前用户日程列表
     */
    List<SysIndexScheduleListResult> scheduleList(SysIndexScheduleListParam sysIndexScheduleListParam);

    /**
     * 获取当前用户站内信列表
     */
    List<SysIndexMessageListResult> messageList(SysIndexMessageListParam sysIndexMessageListParam);

    /**
     * 获取站内信详情
     */
    SysIndexMessageDetailResult messageDetail(SysIndexMessageIdParam sysIndexMessageIdParam);

    /**
     * 站内信全部标记已读
     */
    void allMessageMarkRead();

    /**
     * 获取当前用户访问日志列表
     */
    List<SysIndexVisLogListResult> visLogList();

    /**
     * 获取当前用户操作日志列表
     */
    List<SysIndexOpLogListResult> opLogList();

    /**
     * 创建连接
     **/
    public SseEmitter createSseConnect(String clientId);

}
