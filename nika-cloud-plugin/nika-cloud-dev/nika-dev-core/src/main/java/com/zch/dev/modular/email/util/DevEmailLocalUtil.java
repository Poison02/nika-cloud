package com.zch.dev.modular.email.util;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.zch.dev.api.DevConfigApi;
import com.zch.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 本地邮件工具类
 * @author Zch
 * @date 2023/8/8
 **/
@Slf4j
public class DevEmailLocalUtil {

    private static MailAccount mailAccount;

    private static final String NIKA_EMAIL_LOCAL_FROM_KEY = "NIKA_EMAIL_LOCAL_FROM_KEY";

    private static final String NIKA_EMAIL_LOCAL_PASSWORD_KEY = "NIKA_EMAIL_LOCAL_PASSWORD_KEY";

    private static void initClient() {
        DevConfigApi devConfigApi = SpringUtil.getBean(DevConfigApi.class);

        /* 发件人 */
        String from = devConfigApi.getValueByKey(NIKA_EMAIL_LOCAL_FROM_KEY);
        if (ObjectUtil.isEmpty(from)) {
            throw new CommonException("本地邮件操作客户端未正常配置");
        }

        /* 密码 */
        String password = devConfigApi.getValueByKey(NIKA_EMAIL_LOCAL_PASSWORD_KEY);
        if (ObjectUtil.isEmpty(password)) {
            throw new CommonException("本地邮件操作客户端未正常配置");
        }

        mailAccount = new MailAccount();
        mailAccount.setFrom(from);
        mailAccount.setPass(password);
    }

    public static MailAccount getClient() {
        initClient();
        return mailAccount;
    }

    /**
     * 发送HTML邮件
     * @param tos 收件人，逗号分隔
     * @param subject 主题
     * @param content 内容
     * @param files 文件
     * @return 发送成功的回执id
     */
    public static String sendTextEmail(String tos, String subject, String content, List<File> files) {
        try {
            initClient();
            return MailUtil.send(mailAccount, tos, subject, content, false, ArrayUtil.toArray(files, File.class));
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }
    }

    /**
     * 发送HTML文件
     * @param tos 收件人
     * @param subject 主题
     * @param content 内容
     * @param imageMap 图片与占位符，占位符格式为cid:$IMAGE_PLACEHOLDER
     * @param files 文件
     * @return 发送成功的回执id
     */
    public static String sendHtmlEmail(String tos, String subject, String content, Map<String, InputStream> imageMap, List<File> files) {
        try {
            initClient();
            return MailUtil.send(mailAccount, tos, subject, content, true, ArrayUtil.toArray(files, File.class));
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }
    }

}
