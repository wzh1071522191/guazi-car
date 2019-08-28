package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.AuditDao;
import com.jk.model.Audit;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/20 19:21
 * @description：车辆审核业务层
 * @package ：com.jk.service
 * @version: 1.0.0
 */

@Service(version = "1.0")
@Component
public class AuditServiceImpl implements AuditService{

    @Autowired
    private AuditDao auditDao;

    @Override
    public HashMap<String, Object> queryAuditCar(ParameUtil pu) {
        Integer total=auditDao.queryAuditCarCount();
        Integer page = pu.getPageNumber();
        pu.setPageNumber((page-1)*pu.getPageSize());
        List<Audit> queryList=auditDao.queryListAuditCar(pu);
        HashMap<String,Object> hashMap =new HashMap<String,Object>();
        hashMap.put("total",total);
        hashMap.put("rows",queryList);
        return hashMap;
    }

    @Override
    public String updateStatus(Integer id, Integer flag) {
        HashMap<String,Object> hashMap =new HashMap<String,Object>();
        hashMap.put("id",id);
        hashMap.put("flag",flag);
        auditDao.updateStatus(hashMap);
        return null;
    }

    @Override
    public void upMessage(Audit audit) {
        auditDao.upMessage(audit);
    }
}
