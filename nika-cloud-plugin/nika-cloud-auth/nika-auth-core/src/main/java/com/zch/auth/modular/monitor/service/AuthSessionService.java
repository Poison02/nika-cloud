package com.zch.auth.modular.monitor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zch.auth.modular.monitor.param.AuthExitSessionParam;
import com.zch.auth.modular.monitor.param.AuthExitTokenParam;
import com.zch.auth.modular.monitor.param.AuthSessionPageParam;
import com.zch.auth.modular.monitor.result.AuthSessionAnalysisResult;
import com.zch.auth.modular.monitor.result.AuthSessionPageResult;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/10
 **/
public interface AuthSessionService {

    /**
     * 会话统计
     * @return
     */
    AuthSessionAnalysisResult analysis();

    /**
     * 查询B端会话
     * @param authSessionPageParam
     * @return
     */
    Page<AuthSessionPageResult> pageForB(AuthSessionPageParam authSessionPageParam);

    /**
     * 查询C端会话
     * @param authSessionPageParam
     * @return
     */
    Page<AuthSessionPageResult> pageForC(AuthSessionPageParam authSessionPageParam);

    /**
     * 强制退出B端会话
     * @param authExitSessionParamList
     */
    void exitSessionForB(List<AuthExitSessionParam> authExitSessionParamList);

    /**
     * 强制退出C端会话
     * @param authExitSessionParamList
     */
    void exitSessionForC(List<AuthExitSessionParam> authExitSessionParamList);

    /**
     * 强制退出B端token
     * @param authExitTokenParamList
     */
    void exitTokenForB(List<AuthExitTokenParam> authExitTokenParamList);

    /**
     * 强制退出C端token
     * @param authExitTokenParamList
     */
    void exitTokenForC(List<AuthExitTokenParam> authExitTokenParamList);
}
