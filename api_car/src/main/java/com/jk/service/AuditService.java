package com.jk.service;

import com.jk.model.Audit;
import com.jk.util.ParameUtil;

import java.util.HashMap;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/20 19:20
 * @description：车辆审核接口
 * @package ：com.jk.service
 * @version: 1.0.1
 */
public interface AuditService {
    HashMap<String, Object> queryAuditCar(ParameUtil pu);

    String updateStatus(Integer id, Integer flag);

    void upMessage(Audit audit);
}
