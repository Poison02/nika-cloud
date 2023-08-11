package com.zch.web.core.handler;

import com.zch.common.pojo.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 * @author Zch
 * @date 2023/8/11
 **/
public class GlobalExceptionHandler {

    /**
     * 不同异常返回不同结果
     **/
    @ResponseBody
    @ExceptionHandler
    public CommonResult<String> handleException(Exception e) {
        return GlobalExceptionUtil.getCommonResult(e);
    }

}
