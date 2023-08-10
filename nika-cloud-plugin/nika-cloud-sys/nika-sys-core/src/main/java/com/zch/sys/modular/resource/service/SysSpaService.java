package com.zch.sys.modular.resource.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zch.sys.modular.resource.entity.SysSpa;
import com.zch.sys.modular.resource.param.spa.SysSpaAddParam;
import com.zch.sys.modular.resource.param.spa.SysSpaEditParam;
import com.zch.sys.modular.resource.param.spa.SysSpaIdParam;
import com.zch.sys.modular.resource.param.spa.SysSpaPageParam;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/10
 **/
public interface SysSpaService extends IService<SysSpa> {

    /**
     * 获取单页面分页
     */
    Page<SysSpa> page(SysSpaPageParam sysSpaPageParam);

    /**
     * 添加单页面
     */
    void add(SysSpaAddParam sysSpaAddParam);

    /**
     * 编辑单页面
     */
    void edit(SysSpaEditParam sysSpaEditParam);

    /**
     * 删除单页面
     */
    void delete(List<SysSpaIdParam> sysSpaIdParamList);

    /**
     * 获取单页面详情
     */
    SysSpa detail(SysSpaIdParam sysSpaIdParam);

    /**
     * 获取单页面详情
     */
    SysSpa queryEntity(String id);

}
