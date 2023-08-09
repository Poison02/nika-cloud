package com.zch.dev.modular.sms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zch.dev.modular.sms.entity.DevSms;
import com.zch.dev.modular.sms.enums.DevSmsEngineTypeEnum;
import com.zch.dev.modular.sms.mapper.DevSmsMapper;
import com.zch.dev.modular.sms.param.DevSmsIdParam;
import com.zch.dev.modular.sms.param.DevSmsPageParam;
import com.zch.dev.modular.sms.param.DevSmsSendAliyunParam;
import com.zch.dev.modular.sms.param.DevSmsSendTencentParam;
import com.zch.dev.modular.sms.service.DevSmsService;
import com.zch.dev.modular.sms.util.DevSmsAliyunUtil;
import com.zch.dev.modular.sms.util.DevSmsTencentUtil;
import com.zch.enums.CommonSortOrderEnum;
import com.zch.exception.CommonException;
import com.zch.page.CommonPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/9
 **/
@Service
public class DevSmsServiceImpl extends ServiceImpl<DevSmsMapper, DevSms> implements DevSmsService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void sendAliyun(DevSmsSendAliyunParam devSmsSendAliyunParam) {
        validPhone(devSmsSendAliyunParam.getPhoneNumbers());
        String receiptInfo = DevSmsAliyunUtil.sendSms(devSmsSendAliyunParam.getPhoneNumbers(), devSmsSendAliyunParam.getSignName(),
                devSmsSendAliyunParam.getTemplateCode(), devSmsSendAliyunParam.getTemplateParam());
        DevSms devSms = new DevSms();
        BeanUtil.copyProperties(devSmsSendAliyunParam, devSms);
        devSms.setEngine(DevSmsEngineTypeEnum.ALIYUN.getValue());
        devSms.setReceiptInfo(receiptInfo);
        this.save(devSms);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void sendTencent(DevSmsSendTencentParam smsSendTencentParam) {
        validPhone(smsSendTencentParam.getPhoneNumbers());
        String receiptInfo = DevSmsTencentUtil.sendSms(smsSendTencentParam.getSdkAppId(), smsSendTencentParam.getPhoneNumbers(),
                smsSendTencentParam.getSignName(), smsSendTencentParam.getTemplateCode(), smsSendTencentParam.getTemplateParam());
        DevSms devSms = new DevSms();
        BeanUtil.copyProperties(smsSendTencentParam, devSms);
        devSms.setEngine(DevSmsEngineTypeEnum.TENCENT.getValue());
        devSms.setReceiptInfo(receiptInfo);
        this.save(devSms);
    }

    @Override
    public Page<DevSms> page(DevSmsPageParam devSmsPageParam) {
        QueryWrapper<DevSms> queryWrapper = new QueryWrapper<>();
        if(ObjectUtil.isNotEmpty(devSmsPageParam.getEngine())) {
            queryWrapper.lambda().eq(DevSms::getEngine, devSmsPageParam.getEngine());
        }
        if(ObjectUtil.isNotEmpty(devSmsPageParam.getSearchKey())) {
            queryWrapper.lambda().like(DevSms::getPhoneNumbers, devSmsPageParam.getSearchKey());
        }
        if(ObjectUtil.isAllNotEmpty(devSmsPageParam.getSortField(), devSmsPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(devSmsPageParam.getSortOrder());
            queryWrapper.orderBy(true, devSmsPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()),
                    StrUtil.toUnderlineCase(devSmsPageParam.getSortField()));
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Override
    public void delete(List<DevSmsIdParam> devSmsIdParamList) {
        this.removeByIds(CollStreamUtil.toList(devSmsIdParamList, DevSmsIdParam::getId));
    }

    @Override
    public DevSms detail(DevSmsIdParam devSmsIdParam) {
        return this.queryEntity(devSmsIdParam.getId());
    }

    @Override
    public DevSms queryEntity(String id) {
        DevSms devSms = this.getById(id);
        if(ObjectUtil.isEmpty(devSms)) {
            throw new CommonException("短信不存在，id值为：{}", id);
        }
        return devSms;
    }

    /**
     * 校验手机格式
     **/
    private void validPhone(String phones) {
        StrUtil.split(phones, StrUtil.COMMA).forEach(phone -> {
            if(!PhoneUtil.isMobile(phone)) {
                throw new CommonException("手机号码：{}格式错误", phone);
            }
        });
    }

}
