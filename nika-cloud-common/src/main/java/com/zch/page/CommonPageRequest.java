package com.zch.page;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zch.util.CommonServletUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 通用分页请求
 * @author Zch
 * @date 2023/8/5
 **/
@Slf4j
public class CommonPageRequest {

    private static final String PAGE_SIZE_PARAM_NAME = "size";

    private static final String PAGE_PARAM_NAME = "current";

    private static final Integer PAGE_SIZE_MAX_VALUE = 100;

    public static <T> Page<T> defaultPage() {
        return defaultPage(null);
    }

    public static <T> Page<T> defaultPage(List<OrderItem> orderItemList) {
        int size = 20;

        int page = 1;

        // 每页条数
        String pageSizeString = CommonServletUtil.getParamFormRequest(PAGE_SIZE_PARAM_NAME);
        if (ObjectUtil.isNotEmpty(pageSizeString)) {
            try {
                size = Convert.toInt(pageSizeString);
                if (size > PAGE_SIZE_MAX_VALUE) {
                    size = PAGE_SIZE_MAX_VALUE;
                }
            } catch (Exception e) {
                log.error(">>> 分页条数转换异常: ", e);
                size = 20;
            }
        }

        // 第几页
        String pageString = CommonServletUtil.getParamFormRequest(PAGE_PARAM_NAME);
        if (ObjectUtil.isNotEmpty(pageString)) {
            try {
                page = Convert.toInt(pageString);
            } catch (Exception e) {
                log.error(">>> 分页页数转换异常：", e);
                page = 1;
            }
        }

        Page<T> objectPage = new Page<>(page, size);
        if (ObjectUtil.isNotEmpty(orderItemList)) {
            objectPage.setOrders(orderItemList);
        }
        return objectPage;
    }

}
