package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.CommService;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("comm")
public class CommController {
    @Reference
    private CommService se;
    //订单查询全部
    @RequestMapping("cha")
    @ResponseBody
    public DataGridResult chauxn(@RequestBody ParameUtil param){
         DataGridResult da=new DataGridResult();
        PageUtil pa=se.cha(param);
        da.setTotal(pa.getSumSize());
        da.setRows(pa.getList());
      return da;
    }


}
