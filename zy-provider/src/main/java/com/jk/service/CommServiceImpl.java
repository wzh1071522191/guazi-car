package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.jk.dao.CommDao;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(version = "1.0")
@Component
public class CommServiceImpl implements CommService {
@Autowired
    private CommDao da;

    @Override
    public PageUtil cha(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        return null;
    }
}
