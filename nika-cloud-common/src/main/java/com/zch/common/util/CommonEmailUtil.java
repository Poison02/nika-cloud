package com.zch.common.util;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.zch.common.exception.CommonException;

/**
 * 通用邮件工具类
 * @author Zch
 * @date 2023/8/5
 **/
public class CommonEmailUtil {

    /**
     * 判断是否是邮件
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        return Validator.isEmail(email);
    }

    /**
     * 校验邮件格式
     * @param emails
     */
    public static void validEmail(String emails) {
        StrUtil.split(emails, StrUtil.COMMA).forEach(email -> {
            if (!isEmail(email)) {
                throw new CommonException("邮件地址：{}格式错误", email);
            }
        });
    }

}
