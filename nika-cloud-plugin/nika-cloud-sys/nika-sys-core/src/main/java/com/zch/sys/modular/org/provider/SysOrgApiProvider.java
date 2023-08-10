package com.zch.sys.modular.org.provider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zch.sys.api.SysOrgApi;
import com.zch.sys.modular.org.entity.SysOrg;
import com.zch.sys.modular.org.param.SysOrgSelectorOrgListParam;
import com.zch.sys.modular.org.service.SysOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zch
 * @date 2023/8/10
 **/
@Service
public class SysOrgApiProvider implements SysOrgApi {

    @Resource
    private SysOrgService sysOrgService;

    @Override
    public String getNameById(String orgId) {
        return sysOrgService.queryEntity(orgId).getName();
    }

    @Override
    public String getSupervisorIdByOrgId(String orgId) {
        SysOrg sysOrg = sysOrgService.getById(orgId);
        if(ObjectUtil.isNotEmpty(sysOrg)) {
            return sysOrg.getDirectorId();
        }
        return null;
    }

    @Override
    public List<Tree<String>> orgTreeSelector() {
        return sysOrgService.orgTreeSelector();
    }

    @SuppressWarnings("ALL")
    @Override
    public Page<JSONObject> orgListSelector(String parentId) {
        SysOrgSelectorOrgListParam sysOrgSelectorOrgListParam = new SysOrgSelectorOrgListParam();
        sysOrgSelectorOrgListParam.setParentId(parentId);
        return BeanUtil.toBean(sysOrgService.orgListSelector(sysOrgSelectorOrgListParam), Page.class);
    }

}
