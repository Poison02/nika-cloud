package com.zch.dev.modular.message.service;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zch.dev.modular.message.entity.DevMessage;
import com.zch.dev.modular.message.param.DevMessageIdParam;
import com.zch.dev.modular.message.param.DevMessageListParam;
import com.zch.dev.modular.message.param.DevMessagePageParam;
import com.zch.dev.modular.message.param.DevMessageSendParam;
import com.zch.dev.modular.message.result.DevMessageResult;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/9
 **/
public interface DevMessageService extends IService<DevMessage> {

    /**
     * 发送站内信
     **/
    void send(DevMessageSendParam devMessageSendParam);

    /**
     * 获取站内信分页
     */
    Page<DevMessage> page(DevMessagePageParam devMessagePageParam);

    /**
     * 获取站内信分页，返回JSONObject分页
     */
    Page<JSONObject> page(List<String> receiverIdList, String category);

    /**
     * 获取站内信列表
     */
    List<DevMessage> list(DevMessageListParam devMessageListParam);

    /**
     * 获取未读站内信数量
     */
    Long unreadCount(String loginId);

    /**
     * 删除站内信
     **/
    void delete(List<DevMessageIdParam> devMessageIdParamList);

    /**
     * 获取站内信详情
     */
    DevMessageResult detail(DevMessageIdParam devMessageIdParam);

    /**
     * 获取站内信详情
     */
    DevMessage queryEntity(String id);

}
