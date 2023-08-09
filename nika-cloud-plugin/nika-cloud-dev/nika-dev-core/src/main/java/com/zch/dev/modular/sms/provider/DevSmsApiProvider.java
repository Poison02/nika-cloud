package com.zch.dev.modular.sms.provider;

import com.zch.dev.api.DevSmsApi;
import com.zch.dev.modular.sms.param.DevSmsSendAliyunParam;
import com.zch.dev.modular.sms.param.DevSmsSendTencentParam;
import com.zch.dev.modular.sms.service.DevSmsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Zch
 * @date 2023/8/9
 **/
@Service
public class DevSmsApiProvider implements DevSmsApi {

    @Resource
    private DevSmsService devSmsService;

    @Override
    public void sendSmsAliyun(String phoneNumbers, String signName, String templateCode, String templateParam) {
        DevSmsSendAliyunParam devSmsSendAliyunParam = new DevSmsSendAliyunParam();
        devSmsSendAliyunParam.setPhoneNumbers(phoneNumbers);
        devSmsSendAliyunParam.setSignName(signName);
        devSmsSendAliyunParam.setTemplateCode(templateCode);
        devSmsSendAliyunParam.setTemplateParam(templateParam);
        devSmsService.sendAliyun(devSmsSendAliyunParam);
    }

    @Override
    public void sendSmsTencent(String sdkAppId, String phoneNumbers, String signName, String templateCode, String templateParam) {
        DevSmsSendTencentParam devSmsSendTencentParam = new DevSmsSendTencentParam();
        devSmsSendTencentParam.setSdkAppId(sdkAppId);
        devSmsSendTencentParam.setPhoneNumbers(phoneNumbers);
        devSmsSendTencentParam.setSignName(signName);
        devSmsSendTencentParam.setTemplateCode(templateCode);
        devSmsSendTencentParam.setTemplateParam(templateParam);
        devSmsService.sendTencent(devSmsSendTencentParam);
    }
}
