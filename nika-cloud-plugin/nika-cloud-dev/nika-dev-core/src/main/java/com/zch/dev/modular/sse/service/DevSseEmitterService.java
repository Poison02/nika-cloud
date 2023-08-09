package com.zch.dev.modular.sse.service;


import com.zch.sse.CommonSseParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.function.Consumer;

/**
 * @author Zch
 * @date 2023/8/9
 **/
public interface DevSseEmitterService  {

    /**
     * 创建连接
     **/
    public SseEmitter createSseConnect(String clientId, Boolean setHeartBeat, Boolean defaultHeartbeat, Consumer<CommonSseParam> consumer);

    /**
     * 关闭连接
     **/
    public void closeSseConnect(String clientId);

    /**
     * 推送消息到所有客户端
     **/
    public void sendMessageToAllClient(String msg);

    /**
     * 根据clientId发送消息给某一客户端
     **/
    public void sendMessageToOneClient(String clientId, String msg);

}
