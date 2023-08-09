package com.zch.common.pojo;

import cn.hutool.json.JSONObject;

/**
 * 通用包装接口
 * @author Zch
 * @date 2023/8/5
 **/
public interface CommonWrapperInterface<T> {

    /**
     * 执行包装
     * @param wrapperObject 要包装对象的类型
     * @return JSONObject
     */
    JSONObject doWrap(T wrapperObject);

}
