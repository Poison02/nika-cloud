package com.zch.dev.modular.sms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zch.common.annotation.CommonLog;
import com.zch.dev.modular.sms.entity.DevSms;
import com.zch.dev.modular.sms.param.DevSmsIdParam;
import com.zch.dev.modular.sms.param.DevSmsPageParam;
import com.zch.dev.modular.sms.param.DevSmsSendAliyunParam;
import com.zch.dev.modular.sms.param.DevSmsSendTencentParam;
import com.zch.dev.modular.sms.service.DevSmsService;
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
 * @date 2023/8/9
 **/
@Api(tags = "短信Controller")
@ApiSupport(author = "Zch", order = 5)
@RestController
@Validated
public class DevSmsController {

    @Resource
    private DevSmsService devSmsService;

    /**
     * 发送短信——阿里云
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation("发送阿里云短信")
    @CommonLog("发送阿里云短信")
    @PostMapping("/dev/sms/sendAliyun")
    public CommonResult<String> sendAliyun(@RequestBody @Valid DevSmsSendAliyunParam devSmsSendAliyunParam) {
        devSmsService.sendAliyun(devSmsSendAliyunParam);
        return CommonResult.ok();
    }

    /**
     * 发送短信——腾讯云
     */
    @ApiOperationSupport(order = 2)
    @ApiOperation("发送腾讯云短信")
    @CommonLog("发送腾讯云短信")
    @PostMapping("/dev/sms/sendTencent")
    public CommonResult<String> sendTencent(@RequestBody @Valid DevSmsSendTencentParam devSmsSendTencentParam) {
        devSmsService.sendTencent(devSmsSendTencentParam);
        return CommonResult.ok();
    }

    /**
     * 获取短信分页
     */
    @ApiOperationSupport(order = 3)
    @ApiOperation("获取短信分页")
    @GetMapping("/dev/sms/page")
    public CommonResult<Page<DevSms>> page(DevSmsPageParam devSmsPageParam) {
        return CommonResult.data(devSmsService.page(devSmsPageParam));
    }

    /**
     * 删除短信
     */
    @ApiOperationSupport(order = 4)
    @ApiOperation("删除短信")
    @CommonLog("删除短信")
    @PostMapping("/dev/sms/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                       CommonValidList<DevSmsIdParam> devSmsIdParamList) {
        devSmsService.delete(devSmsIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取短信详情
     */
    @ApiOperationSupport(order = 5)
    @ApiOperation("获取短信详情")
    @GetMapping("/dev/sms/detail")
    public CommonResult<DevSms> detail(@Valid DevSmsIdParam devSmsIdParam) {
        return CommonResult.data(devSmsService.detail(devSmsIdParam));
    }
}
