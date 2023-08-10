package com.zch.auth.modular.third.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zch.auth.modular.third.entity.AuthThirdUser;
import com.zch.auth.modular.third.param.AuthThirdCallbackParam;
import com.zch.auth.modular.third.param.AuthThirdRenderParam;
import com.zch.auth.modular.third.param.AuthThirdUserPageParam;
import com.zch.auth.modular.third.result.AuthThirdRenderResult;
import com.zch.auth.modular.third.service.AuthThirdService;
import com.zch.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhyd.oauth.model.AuthCallback;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author Zch
 * @date 2023/8/10
 **/
@Api(tags = "第三方登录Controller")
@ApiSupport(author = "Zch", order = 5)
@RestController
@Validated
public class AuthThirdController {

    @Resource
    private AuthThirdService authThirdService;

    /**
     * 第三方登录页面渲染
     **/
    @ApiOperationSupport(order = 1)
    @ApiOperation("第三方登录页面渲染")
    @GetMapping("/auth/third/render")
    public CommonResult<AuthThirdRenderResult> render(@Valid AuthThirdRenderParam authThirdRenderParam) {
        return CommonResult.data(authThirdService.render(authThirdRenderParam));
    }

    /**
     * 第三方登录授权回调
     **/
    @ApiOperationSupport(order = 2)
    @ApiOperation("第三方登录授权回调")
    @GetMapping("/auth/third/callback")
    public CommonResult<String> callback(@Valid AuthThirdCallbackParam authThirdCallbackParam, AuthCallback authCallback) {
        return CommonResult.data(authThirdService.callback(authThirdCallbackParam, authCallback));
    }

    /**
     * 获取三方用户分页
     */
    @ApiOperationSupport(order = 3)
    @ApiOperation("获取三方用户分页")
    @GetMapping("/auth/third/page")
    public CommonResult<Page<AuthThirdUser>> page(AuthThirdUserPageParam authThirdUserPageParam) {
        return CommonResult.data(authThirdService.page(authThirdUserPageParam));
    }
}
