package com.zch.dev.modular.log.provider;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zch.auth.core.util.StpLoginUserUtil;
import com.zch.dev.api.DevLogApi;
import com.zch.dev.modular.log.entity.DevLog;
import com.zch.dev.modular.log.enums.DevLogCategoryEnum;
import com.zch.dev.modular.log.service.DevLogService;
import com.zch.dev.modular.log.util.DevLogUtil;
import com.zch.page.CommonPageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 日志api接口实现类
 *
 * @author Zch
 * @date 2023/8/7
 **/
@Service
public class DevLogApiProvider implements DevLogApi {

    @Resource
    private DevLogService devLogService;

    @Override
    public void executeLoginLog(String userName) {
        DevLogUtil.executeLoginLog(userName);
    }

    @Override
    public void executeLogoutLog(String userName) {
        DevLogUtil.executeLoginLog(userName);
    }

    @Override
    public List<JSONObject> currentUserVisLogList() {
        return devLogService.page(CommonPageRequest.defaultPage(), new LambdaQueryWrapper<DevLog>()
                        .eq(DevLog::getOpUser, StpLoginUserUtil.getLoginUser().getName())
                        .in(DevLog::getCategory, DevLogCategoryEnum.LOGIN.getValue(), DevLogCategoryEnum.LOGOUT.getValue())
                        .orderByDesc(DevLog::getCreateTime))
                .getRecords().stream().map(JSONUtil::parseObj)
                .collect(Collectors.toList());
    }

    @Override
    public List<JSONObject> currentUserOpLogList() {
        return devLogService.page(CommonPageRequest.defaultPage(), new LambdaQueryWrapper<DevLog>()
                        .eq(DevLog::getOpUser, StpLoginUserUtil.getLoginUser().getName())
                        .in(DevLog::getCategory, DevLogCategoryEnum.OPERATE.getValue(), DevLogCategoryEnum.EXCEPTION.getValue())
                        .orderByDesc(DevLog::getCreateTime))
                .getRecords().stream().map(JSONUtil::parseObj).collect(Collectors.toList());
    }
}
