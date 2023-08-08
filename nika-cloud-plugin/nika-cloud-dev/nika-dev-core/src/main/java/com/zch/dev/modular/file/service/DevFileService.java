package com.zch.dev.modular.file.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zch.dev.modular.file.entity.DevFile;
import com.zch.dev.modular.file.param.DevFileIdParam;
import com.zch.dev.modular.file.param.DevFileListParam;
import com.zch.dev.modular.file.param.DevFilePageParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Zch
 * @date 2023/8/8
 **/
public interface DevFileService extends IService<DevFile> {

    /**
     * MultipartFile文件上传，返回文件id
     **/
    String uploadReturnId(String engine, MultipartFile file);

    /**
     * MultipartFile文件上传，返回文件Url
     **/
    String uploadReturnUrl(String engine, MultipartFile file);

    /**
     * 文件分页列表接口
     **/
    Page<DevFile> page(DevFilePageParam devFilePageParam);

    /**
     * 文件列表接口
     **/
    List<DevFile> list(DevFileListParam devFileListParam);

    /**
     * 下载文件
     **/
    void download(DevFileIdParam devFileIdParam, HttpServletResponse response) throws IOException;

    /**
     * 删除文件
     **/
    void delete(List<DevFileIdParam> devFileIdParamList);

    /**
     * 获取文件详情
     */
    DevFile detail(DevFileIdParam devFileIdParam);

    /**
     * 获取文件详情
     */
    DevFile queryEntity(String id);

}
