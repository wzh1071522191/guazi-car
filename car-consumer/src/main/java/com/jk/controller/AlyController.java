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

    //跳转今天html页面-
    @RequestMapping("/toshopping")
    public String tobinzhuang() {

        return "xqt/shopping.html";
    }

    //跳转近七天html页面---
    @RequestMapping("/tosevenHtml")
    public String toTodayHtml() {

        return "xqt/sevenlist.html";
    }

    //跳转近30天html页面---
    @RequestMapping("/tothreesHtml")
    public String tothreesHtml() {

        return "xqt/threeslist.html";
    }

    //测试浮点图
    @RequestMapping("/fudian")
    public String fudian() {

        return "xqt/fudian.html";
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


    //支付状态饼状图--全部数据
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

    //柱状图--全部数据
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
            } else if (zhuangkuang == 4) {
                map.put("name", "事故车");
                int[] aa = new int[]{150, 200, 1000, 129};
                map.put("data", aa);
            }
            list1.add(map);
        }
        return list1;
    }
//年份折线图
    @RequestMapping("queryShoppingZhexianNian")
    @ResponseBody
    public Map<String,Object> queryShoppingZhexian(){
       List<Map<String,Object>> list = alyService.queryShoppingZhexian();
       String[] week = new String[list.size()];
        int[] count = new int[list.size()];
        for (int i=0;i<list.size();i++){
            if(list.get(i).get("week").equals("2017")){
                week[i] = "2017";
            }
            if(list.get(i).get("week").equals("2018")){
                week[i] = "2018";
            }
            if(list.get(i).get("week").equals("2019")){
                week[i] = "2019";
            }
            count[i] = Integer.parseInt(list.get(i).get("count").toString());
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("week",week);
        map.put("count",count);
        return map;
    }
//展示近七天折线图
@RequestMapping("queryShoppingZhexianWeek")
@ResponseBody
public Map<String,Object> queryShoppingZhexianWeek(){
    List<Map<String,Object>> list = alyService.queryShoppingZhexianWeek();
    String[] week = new String[list.size()];
    int[] count = new int[list.size()];
    for (int i=0;i<list.size();i++){
        if(list.get(i).get("week").equals("1")){
            week[i] = "星期一";
        }
        if(list.get(i).get("week").equals("2")){
            week[i] = "星期二";
        }
        if(list.get(i).get("week").equals("3")){
            week[i] = "星期三";
        }
        if(list.get(i).get("week").equals("4")){
            week[i] = "星期四";
        }
        if(list.get(i).get("week").equals("5")){
            week[i] = "星期五";
        }
        if(list.get(i).get("week").equals("6")){
            week[i] = "星期六";
        }
        if(list.get(i).get("week").equals("0")){
            week[i] = "星期日";
        }
        count[i] = Integer.parseInt(list.get(i).get("count").toString());
    }
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("week",week);
    map.put("count",count);
    return map;
}
//展示每月的数据--折线
@RequestMapping("queryShoppingZhexianYue")
@ResponseBody
public Map<String,Object> queryShoppingZhexianYue(){
    List<Map<String,Object>> list = alyService.queryShoppingZhexianYue();
    String[] week = new String[list.size()];
    int[] count = new int[list.size()];
    for (int i=0;i<list.size();i++){
        if(list.get(i).get("week").equals("01")){
            week[i] = "一月";
        }
        if(list.get(i).get("week").equals("02")){
            week[i] = "二月";
        }
        if(list.get(i).get("week").equals("03")){
            week[i] = "三月";
        }
        if(list.get(i).get("week").equals("04")){
            week[i] = "四月";
        }
        if(list.get(i).get("week").equals("05")){
            week[i] = "五月";
        }
        if(list.get(i).get("week").equals("06")){
            week[i] = "六月";
        }
        if(list.get(i).get("week").equals("07")){
            week[i] = "七月";
        }
        if(list.get(i).get("week").equals("08")){
            week[i] = "八月";
        }
        if(list.get(i).get("week").equals("09")){
            week[i] = "九月";
        }
        if(list.get(i).get("week").equals("10")){
            week[i] = "十月";
        }
        if(list.get(i).get("week").equals("11")){
            week[i] = "十一月";
        }
        if(list.get(i).get("week").equals("12")){
            week[i] = "十二月";
        }
        count[i] = Integer.parseInt(list.get(i).get("count").toString());
    }
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("week",week);
    map.put("count",count);
    return map;
}
//各个月份柱形图
@RequestMapping("queryShoppingZhuxingByMonth")
@ResponseBody
public Map<String,Object> queryShoppingZhuxingByMonth(){
    List<Map<String,Object>> list = alyService.queryShoppingZhuxingByMonth();
    String[] month = new String[list.size()];
    int[] count = new int[list.size()];
    for (int i=0;i<list.size();i++){
        if(list.get(i).get("month").equals("01")){
            month[i] = "一月";
        }
        if(list.get(i).get("month").equals("02")){
            month[i] = "二月";
        }
        if(list.get(i).get("month").equals("03")){
            month[i] = "三月";
        }
        if(list.get(i).get("month").equals("04")){
            month[i] = "四月";
        }
        if(list.get(i).get("month").equals("05")){
            month[i] = "五月";
        }
        if(list.get(i).get("month").equals("06")){
            month[i] = "六月";
        }
        if(list.get(i).get("month").equals("07")){
            month[i] = "七月";
        }
        if(list.get(i).get("month").equals("08")){
            month[i] = "八月";
        }
        if(list.get(i).get("month").equals("09")){
            month[i] = "九月";
        }
        if(list.get(i).get("month").equals("10")){
            month[i] = "十月";
        }
        if(list.get(i).get("month").equals("11")){
            month[i] = "十一月";
        }
        if(list.get(i).get("month").equals("12")){
            month[i] = "十二月";
        }
        count[i] = Integer.parseInt(list.get(i).get("count").toString());
    }
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("month",month);
    map.put("count",count);
    return map;
}
//每年---柱形图
@RequestMapping("queryShoppingZhuxingByYear")
@ResponseBody
public Map<String,Object> queryShoppingZhuxingByYear(){
    List<Map<String,Object>> list = alyService.queryShoppingZhuxingByYear();
    String[] month = new String[list.size()];
    int[] count = new int[list.size()];
    for (int i=0;i<list.size();i++){
        if(list.get(i).get("month").equals("2017")){
            month[i] = "2017";
        }
        if(list.get(i).get("month").equals("2018")){
            month[i] = "2018";
        }
        if(list.get(i).get("month").equals("2019")){
            month[i] = "2019";
        }

        count[i] = Integer.parseInt(list.get(i).get("count").toString());
    }
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("month",month);
    map.put("count",count);
    return map;
}
//按星期--柱状图
@RequestMapping("queryShoppingZhuxingByWeek")
@ResponseBody
public Map<String,Object> queryShoppingZhuxingByWeek(){
    List<Map<String,Object>> list = alyService.queryShoppingZhuxingByWeek();
    String[] month = new String[list.size()];
    int[] count = new int[list.size()];
    for (int i=0;i<list.size();i++){
        if(list.get(i).get("month").equals("1")){
            month[i] = "星期一";
        }
        if(list.get(i).get("month").equals("2")){
            month[i] = "星期二";
        }
        if(list.get(i).get("month").equals("3")){
            month[i] = "星期三";
        }
        if(list.get(i).get("month").equals("4")){
            month[i] = "星期四";
        }
        if(list.get(i).get("month").equals("5")){
            month[i] = "星期五";
        }
        if(list.get(i).get("month").equals("6")){
            month[i] = "星期六";
        }
        if(list.get(i).get("month").equals("7")){
            month[i] = "星期日";
        }

        count[i] = Integer.parseInt(list.get(i).get("count").toString());
    }
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("month",month);
    map.put("count",count);
    return map;
}
//天/面积图
@RequestMapping("queryMianjiShopping")
@ResponseBody
public Map<String,Object> queryMianjiShopping(){
    List<Map<String,Object>> list = alyService.queryMianjiShopping();
    String[] day = new String[list.size()];
    int[] count = new int[list.size()];
    for (int i=0;i<list.size();i++){
        day[i] = list.get(i).get("day").toString();
        count[i] = Integer.parseInt(list.get(i).get("count").toString());
    }
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("day",day);
    map.put("count",count);
    return map;
}

}