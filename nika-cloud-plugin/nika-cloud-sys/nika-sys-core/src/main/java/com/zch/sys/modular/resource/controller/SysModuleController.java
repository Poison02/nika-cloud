package com.zch.sys.modular.resource.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zch.common.annotation.CommonLog;
import com.zch.common.pojo.CommonResult;
import com.zch.common.pojo.CommonValidList;
import com.zch.sys.modular.resource.entity.SysModule;
import com.zch.sys.modular.resource.param.module.SysModuleAddParam;
import com.zch.sys.modular.resource.param.module.SysModuleEditParam;
import com.zch.sys.modular.resource.param.module.SysModuleIdParam;
import com.zch.sys.modular.resource.param.module.SysModulePageParam;
import com.zch.sys.modular.resource.service.SysModuleService;
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
@Api(tags = "模块Controller")
@ApiSupport(author = "Zch", order = 6)
@RestController
@Validated
public class SysModuleController {

    @Resource
    private SysModuleService sysModuleService;

    /**
     * 获取模块分页
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation("获取模块分页")
    @GetMapping("/sys/module/page")
    public CommonResult<Page<SysModule>> page(SysModulePageParam sysModulePageParam) {
        return CommonResult.data(sysModuleService.page(sysModulePageParam));
    }

    /**
     * 添加模块
     */
    @ApiOperationSupport(order = 2)
    @ApiOperation("添加模块")
    @CommonLog("添加模块")
    @PostMapping("/sys/module/add")
    public CommonResult<String> add(@RequestBody @Valid SysModuleAddParam sysModuleAddParam) {
        sysModuleService.add(sysModuleAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑模块
     */
    @ApiOperationSupport(order = 3)
    @ApiOperation("编辑模块")
    @CommonLog("编辑模块")
    @PostMapping("/sys/module/edit")
    public CommonResult<String> edit(@RequestBody @Valid SysModuleEditParam sysModuleEditParam) {
        sysModuleService.edit(sysModuleEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除模块
     */
    @ApiOperationSupport(order = 4)
    @ApiOperation("删除模块")
    @CommonLog("删除模块")
    @PostMapping("/sys/module/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                       CommonValidList<SysModuleIdParam> sysModuleIdParamList) {
        sysModuleService.delete(sysModuleIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取模块详情
     */
    @ApiOperationSupport(order = 5)
    @ApiOperation("获取模块详情")
    @GetMapping("/sys/module/detail")
    public CommonResult<SysModule> detail(@Valid SysModuleIdParam sysModuleIdParam) {
        return CommonResult.data(sysModuleService.detail(sysModuleIdParam));
    }
}
