package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.RoundImgMapper;
import com.jk.model.RoundImg;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-08-20 20:19
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@Service
public class ImgServiceImpl implements  ImgService {
@Autowired
private RoundImgMapper imgmapper;
  /*  @Override
    public Map queryImg(Integer page, Integer rows) {
        long count= imgmapper.queryCount();
        int stat=(page-1)* rows;
        List<RoundImg> list=imgmapper.queryList(stat,rows);
        Map map =new HashMap();
        map.put("rows",list);
        map.put("total",count);
        return map;
    }
*/
    @Override
    public void addImg(RoundImg roundimg) {
        roundimg.setImgzt(2);
        imgmapper.addImg(roundimg);
    }

    @Override
    public void addLbShow(String lbid) {
        System.out.println("999999999999999999"+lbid);
        imgmapper.addLbShow(lbid);
    }

    @Override
    public List<RoundImg> ShowNowLb() {
        return imgmapper.ShowNowLb();
    }

    @Override
    public Map queryImgList(ParameUtil parm) {
        long count =imgmapper.queryCount();
        int stat=(parm.getPageNumber()-1)*parm.getPageSize();
        List<RoundImg> list=imgmapper.queryList1(stat,parm.getPageSize(),parm);
        Map map =new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }

    @Override
    public void delImg(String lbid) {
        imgmapper.delImg(lbid);
    }
}

