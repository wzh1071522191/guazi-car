package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Car;
import com.jk.service.AlyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/analysis")
public class AlyController {

    @Reference
    private AlyService alyService;

    //跳转html页面---商品分析
    @RequestMapping("/toAnalHtml")
    public String toAnalHtml() {

        return "xqt/Analist.html";
    }

    //跳转今天html页面---柱状图
    @RequestMapping("/tozhu")
    public String tobinzhuang() {

        return "xqt/zhu.html";
    }

    //跳转今天html页面---
    @RequestMapping("/toTodayHtml")
    public String toTodayHtml() {

        return "xqt/Todaylist.html";
    }

    /**
     * @return
     * @author :xueqitao
     * @method : 查询商品分析所有的数据
     * @description :查询
     * @date: 2019/8/18 0018 15:32
     * @param:Car car
     */
    @RequestMapping("queryAnaList")
    @ResponseBody
    public HashMap<String, Object> queryAnaList(Car car) {

        return alyService.queryAnaList(car);
    }

    //查询商品分析今天的数据---商品分析
    @RequestMapping("queryTodayAnaList")
    @ResponseBody
    public HashMap<String, Object> queryTodayAnaList(Car car) {

        return alyService.queryTodayAnaList(car);
    }

    //查询商品分析昨天的数据---商品分析
    @RequestMapping("queryYesterdayAnaList")
    @ResponseBody
    public HashMap<String, Object> queryYesterdayAnaList(Car car) {

        return alyService.queryYesterdayAnaList(car);
    }

    //查询商品分析7天内的数据---商品分析
    @RequestMapping("querySevendaysAnaList")
    @ResponseBody
    public HashMap<String, Object> querySevendaysAnaList(Car car) {

        return alyService.querySevendaysAnaList(car);
    }

    //查询商品最近30天的数据---商品分析
    @RequestMapping("queryThirtyAnaList")
    @ResponseBody
    public HashMap<String, Object> queryThirtyAnaList(Car car) {

        return alyService.queryThirtyAnaList(car);
    }

    //线行图---商品分析--全部数据
    @RequestMapping("queryAnalyXian")
    @ResponseBody
    public List<Map<String, Object>> queryAnalyXian() {
        List<Map<String, Object>> list = alyService.queryAnalyXian();
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (Map<String, Object> map1 : list) {

            Map<String, Object> map = new HashMap<>();
            int datajj = Integer.parseInt(map1.get("年份").toString());
            if (datajj == 2017) {
                map.put("name", "趋势");
                int[] aa = new int[]{200, 600, 900, 129};
                map.put("data", aa);
            } else if (datajj == 2018) {
                map.put("name", "趋势");
                int[] aa = new int[]{300, 200, 700, 599};
                map.put("data", aa);
            } else if (datajj == 2019) {
                map.put("name", "趋势");
                int[] aa = new int[]{150, 200, 1000, 129};
                map.put("data", aa);
            }
            list1.add(map);
        }

        return list1;
    }

    //支付状态饼状图
    @RequestMapping("queryBingZhuang")
    @ResponseBody
    public List<Map<String, Object>> queryBingZhuang() {
        List<Map<String, Object>> list = alyService.queryBingZhuang();
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (Map<String, Object> map1 : list) {
            Map<String, Object> map = new HashMap<>();
            int shuliang = (int) map1.get("支付状态");
            if (shuliang == 1) {
                map.put("name", "支付成功");
            } else if (shuliang == 2) {
                map.put("name", "支付未成功");
            } else if (shuliang == 3) {
                map.put("name", "支付中");
            }
            map.put("y", map1.get("数量"));
            map.put("sliced", "true");
            map.put("selected", "true");
            list1.add(map);
        }

        return list1;
    }

    //柱状图
    @RequestMapping("queryZhuzhuang")
    @ResponseBody
    public List<Map<String, Object>> queryZhuzhuang() {
        List<Map<String, Object>> list = alyService.queryZhuzhuang();
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (Map<String, Object> map1 : list) {
            Map<String, Object> map = new HashMap<>();
            int zhuangkuang = (int) map1.get("车况");
            if (zhuangkuang == 1) {
                map.put("name", "好");
                int[] aa = new int[]{200, 600, 900, 129};
                map.put("data", aa);
            } else if (zhuangkuang == 2) {
                map.put("name", "正常");
                int[] aa = new int[]{300, 200, 700, 599};
                map.put("data", aa);
            } else if (zhuangkuang == 3) {
                map.put("name", "一般");
                int[] aa = new int[]{150, 200, 1000, 129};
                map.put("data", aa);
            }else if (zhuangkuang == 4) {
                map.put("name", "事故车");
                int[] aa = new int[]{150, 200, 1000, 129};
                map.put("data", aa);
            }
            list1.add(map);
        }
            return list1;

        }
}