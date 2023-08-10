package com.zch.auth.modular.monitor.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zch.auth.modular.monitor.param.AuthExitSessionParam;
import com.zch.auth.modular.monitor.param.AuthExitTokenParam;
import com.zch.auth.modular.monitor.param.AuthSessionPageParam;
import com.zch.auth.modular.monitor.result.AuthSessionAnalysisResult;
import com.zch.auth.modular.monitor.result.AuthSessionPageResult;
import com.zch.auth.modular.monitor.service.AuthSessionService;
import com.zch.common.annotation.CommonLog;
import com.zch.common.pojo.CommonResult;
import com.zch.common.pojo.CommonValidList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * @author Zch
 * @date 2023/8/10
 **/
@Api(tags = "会话管理Controller")
@ApiSupport(author = "Zch", order = 3)
@RestController
@Validated
public class AuthSessionController {

    @Resource
    private AuthSessionService authSessionService;

    /**
     * 会话统计
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation("会话统计")
    @GetMapping("/auth/session/analysis")
    public CommonResult<AuthSessionAnalysisResult> analysis() {
        return CommonResult.data(authSessionService.analysis());
    }

    /**
     * 查询B端会话
     */
    @ApiOperationSupport(order = 2)
    @ApiOperation("查询B端会话")
    @GetMapping("/auth/session/b/page")
    public CommonResult<Page<AuthSessionPageResult>> pageForB(AuthSessionPageParam authSessionPageParam) {
        return CommonResult.data(authSessionService.pageForB(authSessionPageParam));
    }

    /**
     * 查询C端会话
     */
    @ApiOperationSupport(order = 3)
    @ApiOperation("查询C端会话")
    @GetMapping("/auth/session/c/page")
    public CommonResult<Page<AuthSessionPageResult>> pageForC(AuthSessionPageParam authSessionPageParam) {
        return CommonResult.data(authSessionService.pageForC(authSessionPageParam));
    }

    /**
     * 强退B端会话
     **/
    @ApiOperationSupport(order = 4)
    @ApiOperation("强退B端会话")
    @CommonLog("强退B端会话")
    @PostMapping("/auth/session/b/exit")
    public CommonResult<String> exitSessionForB(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                CommonValidList<AuthExitSessionParam> authExitSessionParamList) {
        authSessionService.exitSessionForB(authExitSessionParamList);
        return CommonResult.ok();
    }

    /**
     * 强退C端会话
     **/
    @ApiOperationSupport(order = 5)
    @ApiOperation("强退C端会话")
    @CommonLog("强退C端会话")
    @PostMapping("/auth/session/c/exit")
    public CommonResult<String> exitSessionForC(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                CommonValidList<AuthExitSessionParam> authExitSessionParamList) {
        authSessionService.exitSessionForC(authExitSessionParamList);
        return CommonResult.ok();
    }

    /**
     * 强退B端token
     **/
    @ApiOperationSupport(order = 6)
    @ApiOperation("强退B端token")
    @CommonLog("强退B端token")
    @PostMapping("/auth/token/b/exit")
    public CommonResult<String> exitTokenForB(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                              CommonValidList<AuthExitTokenParam> authExitTokenParamList) {
        authSessionService.exitTokenForB(authExitTokenParamList);
        return CommonResult.ok();
    }

    /**
     * 强退C端token
     **/
    @ApiOperationSupport(order = 7)
    @ApiOperation("强退C端token")
    @CommonLog("强退C端token")
    @PostMapping("/auth/token/c/exit")
    public CommonResult<String> exitTokenForC(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                              CommonValidList<AuthExitTokenParam> authExitTokenParamList) {
        authSessionService.exitTokenForC(authExitTokenParamList);
        return CommonResult.ok();
    }

}
