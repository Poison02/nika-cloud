package com.zch.dev.modular.dict.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zch.dev.modular.dict.entity.DevDict;
import com.zch.dev.modular.dict.param.*;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/8
 **/
public interface DevDictService extends IService<DevDict> {

    /**
     * 获取字典分页
     * @param devDictPageParam
     * @return
     */
    Page<DevDict> page(DevDictPageParam devDictPageParam);

    /**
     * 获取字典列表
     * @param devDictListParam
     * @return
     */
    List<DevDict> list(DevDictListParam devDictListParam);

    /**
     * 获取字典树
     * @param devDictTreeParam
     * @return
     */
    List<Tree<String>> tree(DevDictTreeParam devDictTreeParam);

    /**
     * 添加字典
     * @param devDictAddParam
     */
    void add(DevDictAddParam devDictAddParam);

    /**
     * 编辑字典
     * @param devDictEditParam
     */
    void edit(DevDictEditParam devDictEditParam);

    /**
     * 删除字典
     * @param devDictIdParams
     */
    void delete(List<DevDictIdParam> devDictIdParams);

    /**
     * 获取字典详情
     * @param devDictIdParam
     * @return
     */
    DevDict detail(DevDictIdParam devDictIdParam);

    /**
     * 获取字典详情
     * @param id
     * @return
     */
    DevDict queryEntity(String id);

}
