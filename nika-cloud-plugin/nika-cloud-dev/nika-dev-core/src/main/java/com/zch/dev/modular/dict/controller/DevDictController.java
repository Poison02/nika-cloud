package com.zch.dev.modular.dict.controller;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zch.annotation.CommonLog;
import com.zch.dev.modular.dict.entity.DevDict;
import com.zch.dev.modular.dict.param.*;
import com.zch.dev.modular.dict.service.DevDictService;
import com.zch.pojo.CommonResult;
import com.zch.pojo.CommonValidList;
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
import java.util.List;

/**
 * @author Zch
 * @date 2023/8/8
 **/
@Api(tags = "字典Controller")
@ApiSupport(author = "Zch", order = 2)
@RestController
@Validated
public class DevDictController {

    @Resource
    private DevDictService devDictService;

    @ApiOperationSupport(order = 1)
    @ApiOperation("获取字典分页")
    @GetMapping("/dev/dict/page")
    public CommonResult<Page<DevDict>> page(DevDictPageParam devDictPageParam) {
        return CommonResult.data(devDictService.page(devDictPageParam));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("获取字典列表")
    @GetMapping("/dev/dict/list")
    public CommonResult<List<DevDict>> list(DevDictListParam devDictListParam) {
        return CommonResult.data(devDictService.list(devDictListParam));
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("获取字典树")
    @GetMapping("/dev/dict/tree")
    public CommonResult<List<Tree<String>>> tree(DevDictTreeParam devDictTreeParam) {
        return CommonResult.data(devDictService.tree(devDictTreeParam));
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("添加字典")
    @GetMapping("/dev/dict/add")
    @CommonLog(value = "添加字典")
    public CommonResult<String> add(@RequestBody @Valid DevDictAddParam devDictAddParam) {
        devDictService.add(devDictAddParam);
        return CommonResult.ok();
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("编辑字典")
    @CommonLog(value = "编辑字典")
    @PostMapping("/dev/dict/edit")
    public CommonResult<String> edit(@RequestBody @Valid DevDictEditParam devDictEditParam) {
        devDictService.edit(devDictEditParam);
        return CommonResult.ok();
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("删除字典")
    @CommonLog(value = "删除字典")
    @PostMapping("/dev/dict/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                       CommonValidList<DevDictIdParam> devDictIdParamList) {
        devDictService.delete(devDictIdParamList);
        return CommonResult.ok();
    }

    @ApiOperationSupport(order = 7)
    @ApiOperation("获取字典详情")
    @GetMapping("/dev/dict/detail")
    public CommonResult<DevDict> detail(@Valid DevDictIdParam devDictIdParam) {
        return CommonResult.data(devDictService.detail(devDictIdParam));
    }

}
