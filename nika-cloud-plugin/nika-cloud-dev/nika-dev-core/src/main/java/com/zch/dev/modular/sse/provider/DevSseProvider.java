package com.zch.dev.modular.sse.provider;

import com.zch.dev.api.DevSseApi;
import com.zch.dev.modular.sse.service.DevSseEmitterService;
import com.zch.sse.CommonSseParam;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.Resource;
import java.util.function.Consumer;

/**
 * @author Zch
 * @date 2023/8/9
 **/
@Service
public class DevSseProvider implements DevSseApi {
    @Resource
    private DevSseEmitterService devSseEmitterService;

    /**
     * 创建SSE连接
     **/
    @Override
    public SseEmitter createSseConnect(String clientId, Boolean setHeartBeat, Boolean defaultHeartbeat, Consumer<CommonSseParam> consumer) {
        return devSseEmitterService.createSseConnect(clientId,setHeartBeat,defaultHeartbeat,consumer);
    }

    /**
     * 关闭连接
     **/
    @Override
    public void closeSseConnect(String clientId) {
        devSseEmitterService.closeSseConnect(clientId);
    }

    /**
     * 推送消息到所有客户端
     **/
    @Override
    public void sendMessageToAllClient(String msg) {
        devSseEmitterService.sendMessageToAllClient(msg);
    }

    /**
     * 根据clientId发送消息给某一客户端
     **/
    @Override
    public void sendMessageToOneClient(String clientId, String msg) {
        devSseEmitterService.sendMessageToOneClient(clientId,msg);
    }
}
