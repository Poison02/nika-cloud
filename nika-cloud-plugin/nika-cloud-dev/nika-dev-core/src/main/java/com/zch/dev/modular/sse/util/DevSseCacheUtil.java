package com.zch.dev.modular.sse.util;

import cn.hutool.core.util.StrUtil;
import com.zch.dev.modular.sse.enums.DevSseEmitterParameterEnum;
import com.zch.exception.CommonException;
import com.zch.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.function.Consumer;

/**
 * SSE Emitter工具类
 * @author Zch
 * @date 2023/8/9
 **/
@Slf4j
public class DevSseCacheUtil {

    /**
     * 创建一个容器来存储所有的 SseEmitter
     */
    public static Map<String, Map<String, Object>> sseCache = new ConcurrentHashMap<>();

    /**
     * 根据客户端id获取连接
     * @param clientId
     * @return
     */
    public static SseEmitter getSseEmitterByClientId(String clientId) {
        Map<String, Object> map = sseCache.get(clientId);
        if (map == null || map.isEmpty()) {
            return null;
        }
        return (SseEmitter) map.get(DevSseEmitterParameterEnum.EMITTER.getValue());
    }

    /**
     * 根据客户端id获取心跳
     * @param clientId
     * @return
     */
    public static ScheduledFuture<?> getSseFutureByClientId(String clientId) {
        Map<String, Object> map = sseCache.get(clientId);
        if (map == null || map.isEmpty()) {
            return null;
        }
        return (ScheduledFuture<?>) map.get(DevSseEmitterParameterEnum.FUTURE.getValue());
    }

    /**
     * 根据客户端id获取用户id
     * @param clientId
     * @return
     */
    public static ScheduledFuture<?> getLoginIdByClientId(String clientId) {
        Map<String, Object> map = sseCache.get(clientId);
        if (map == null || map.isEmpty()) {
            return null;
        }
        return (ScheduledFuture<?>) map.get(DevSseEmitterParameterEnum.LOGINID      .getValue());
    }

    /**
     * 根据客户端id获取客户端id
     * @param loginId
     * @return
     */
    public static String getClientIdByLoginId(String loginId){
        if(existSseCache()){
            for (Map.Entry<String, Map<String, Object>> entry : sseCache.entrySet()) {
                Map<String,Object> map = sseCache.get(entry.getKey());
                String lId = (String) map.get(DevSseEmitterParameterEnum.LOGINID.getValue());
                if(loginId.equals(lId)){
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    /**
     * 判断容器是否存在连接
     **/
    public static boolean existSseCache() {
        return sseCache.size()>0;
    }

    /**
     * 判断连接是否有效
     **/
    public static boolean connectionValidity(String clientId,String loginId){
        if(sseCache.get(clientId) == null){
            return false;
        }
        return Objects.equals(loginId, sseCache.get(clientId).get(DevSseEmitterParameterEnum.LOGINID.getValue()));
    }

    /**
     * 增加连接
     **/
    public static void addConnection(String clientId,String loginId, SseEmitter emitter, ScheduledFuture<?> future) {
        final SseEmitter oldEmitter = getSseEmitterByClientId(clientId);
        if (oldEmitter != null) {
            throw new CommonException("连接已存在:{}",clientId);
        }
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put(DevSseEmitterParameterEnum.EMITTER.getValue(),emitter);
        if(future!=null){
            map.put(DevSseEmitterParameterEnum.FUTURE.getValue(), future);
        }
        map.put(DevSseEmitterParameterEnum.LOGINID.getValue(), loginId);
        sseCache.put(clientId, map);
    }

    /**
     * 移除连接
     **/
    public static void removeConnection(String clientId) {
        SseEmitter emitter = getSseEmitterByClientId(clientId);
        if (emitter != null) {
            cancelScheduledFuture(clientId);
        }
        sseCache.remove(clientId);
        log.info("移除连接:{}", clientId);
    }

    /**
     * 中断心跳发送任务
     */
    public static void cancelScheduledFuture(String clientId){
        ScheduledFuture<?> future = getSseFutureByClientId(clientId);
        if (future != null) {
            future.cancel(true);
        }
    }


    /**
     * 长链接完成后回调
     **/
    public static Runnable completionCallBack(String clientId) {
        return () -> {
            log.info("结束连接:{}", clientId);
            removeConnection(clientId);
            cancelScheduledFuture(clientId);
        };
    }

    /**
     * 连接超时回调
     **/
    public static Runnable timeoutCallBack(String clientId){
        return ()->{
            log.info("连接超时:{}", clientId);
            removeConnection(clientId);
            cancelScheduledFuture(clientId);
        };
    }

    /**
     * 推送消息异常时回调
     **/
    public static Consumer<Throwable> errorCallBack(String clientId) {
        return throwable -> {
            log.info("推送消息异常:{}", clientId);
            removeConnection(clientId);
            cancelScheduledFuture(clientId);
        };
    }

    /**
     * 推送消息到所有客户端
     **/
    public static void sendMessageToAllClient(String msg) {
        if (!existSseCache()) {
            return;
        }
        // 判断发送的消息是否为空
        if (StrUtil.isEmpty(msg)){
            log.info("群发消息为空");
            return;
        }
        CommonResult<String> message = new CommonResult<>(CommonResult.CODE_SUCCESS,"",msg);
        for (Map.Entry<String, Map<String, Object>> entry : sseCache.entrySet()) {
            sendMessageToClientByClientId(entry.getKey(), message);
        }
    }

    /**
     * 根据clientId发送消息给某一客户端
     **/
    public static void sendMessageToOneClient(String clientId, String msg) {
        if (StrUtil.isEmpty(clientId)){
            log.info("客户端ID为空");
            return;
        }
        if (StrUtil.isEmpty(msg)){
            log.info("向客户端{}推送消息为空",clientId);
            return;
        }
        CommonResult<String> message = new CommonResult<>(CommonResult.CODE_SUCCESS,"",msg);
        sendMessageToClientByClientId(clientId,message);
    }

    /**
     * 推送消息到客户端
     **/
    public static void sendMessageToClientByClientId(String clientId, CommonResult<String> message) {
        Map<String, Object> map = sseCache.get(clientId);
        if (map==null||map.size()==0) {
            log.error("推送消息失败:客户端{}未创建长链接,失败消息:{}",clientId, message.toString());
            return;
        }
        SseEmitter.SseEventBuilder sendData = SseEmitter.event().data(message, MediaType.APPLICATION_JSON);
        SseEmitter sseEmitter = getSseEmitterByClientId(clientId);
        try {
            Objects.requireNonNull(sseEmitter).send(sendData);
        } catch (Exception e) {
            log.error("推送消息失败,报错异常:",e);
            removeConnection(clientId);
        }
    }

}
