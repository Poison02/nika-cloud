package com.zch.auth.modular.sso.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zch.auth.core.enums.SaClientTypeEnum;
import com.zch.auth.modular.sso.param.AuthSsoTicketLoginParam;
import com.zch.auth.modular.sso.service.AuthSsoService;
import com.zch.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author Zch
 * @date 2023/8/10
 **/
@Api(tags = "单点登录Controller")
@ApiSupport(author = "Zch", order = 4)
@RestController
@Validated
public class AuthSsoController {

    @Resource
    private AuthSsoService authSsoService;

    /**
     * 根据ticket执行单点登录
     *
     * @author xuyuxiang
     * @date 2021/10/15 13:12
     **/
    @ApiOperationSupport(order = 1)
    @ApiOperation("根据ticket执行单点登录")
    @PostMapping("/auth/sso/doLogin")
    public CommonResult<String> doLogin(@RequestBody @Valid AuthSsoTicketLoginParam authAccountPasswordLoginParam) {
        return CommonResult.data(authSsoService.doLogin(authAccountPasswordLoginParam, SaClientTypeEnum.B.getValue()));
    }
}
