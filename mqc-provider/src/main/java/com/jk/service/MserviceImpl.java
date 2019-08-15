package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.Mdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(version="1.0")
@Component
public class MserviceImpl implements Mservice {

    @Autowired
    private Mdao mdao;




}
