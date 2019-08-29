package com.jk.controller;

import com.jk.conf.EsRepository;
import com.jk.elastic.Car;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ： 未振华
 * @date ：Created in 2019/8/28 16:38
 * @description：1
 * @package ：com.jk.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("es")
public class EsController {

    @Autowired
    private EsRepository esRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public Boolean save(Car car){
        try {
            esRepository.save(car);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("tolist")
    public String toList(){
        return "sss/list";
    }

    @RequestMapping("queryCarAll")
    public String queryAllCar(Car car, Model model){

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        if (car.getCarcolor()!=null && !"".equals(car.getCarcolor()))
            boolQueryBuilder.filter(QueryBuilders.termQuery("carcolor",car.getCarcolor()));
        if(car.getCarlc()!=null && !"".equals(car.getCarlc()))
            boolQueryBuilder.filter(QueryBuilders.termQuery("carlc",car.getCarlc()));
        if(car.getCarname()!=null && !"".equals(car.getCarname()))
            boolQueryBuilder.filter(QueryBuilders.matchQuery("carname",car.getCarname()));
        if (car.getCarpl()!=null && car.getCarpl()!=0)//排量
            boolQueryBuilder.filter(QueryBuilders.termQuery("carpl",car.getCarpl()));
        if (car.getCarranyou()!=null && car.getCarranyou() !=0)
            boolQueryBuilder.filter(QueryBuilders.termQuery("carranyou",car.getCarranyou()));
        if (car.getCarmaxprice()!=null && !"".equals(car.getCarmaxprice()) && car.getCarminprice()!=null && !"".equals(car.getCarminprice())) {
            boolQueryBuilder.filter(QueryBuilders.rangeQuery("carprice").from(car.getCarminprice()).to(car.getCarmaxprice()));
        }else {
            if (car.getCarminprice()!=null && !"".equals(car.getCarminprice())){
                 boolQueryBuilder.filter(QueryBuilders.rangeQuery("carprice").gte(car.getCarminprice()));
            }
            if (car.getCarmaxprice()!=null && !"".equals(car.getCarmaxprice())){
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("carprice").lte(car.getCarmaxprice()));
            }
        }

        //获取高亮的组件
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("carname");
        highlightBuilder.preTags("<span style='color:red;'>");
        highlightBuilder.postTags("</span>");

        SearchRequestBuilder productindex = elasticsearchTemplate.getClient().prepareSearch("carindex")
                .setExplain(true)  //设置是否对相关度进行排序   这里设置的是 是
                .highlighter(highlightBuilder)  // 设置高亮策略
                .setQuery(boolQueryBuilder) //设置查询策略
                .setTypes("car")    //设置 索引中的类名
                .addSort("carprice", SortOrder.DESC) //设置 排序 策略  这里是对  商品价格  进行  逆序排序
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);//设置查询的类型  有四种

        SearchResponse searchResponse = productindex.get();

        SearchHits hits = searchResponse.getHits();
        //获取总条数
        int totalHits = (int) hits.totalHits;

        //获取数据存放的组件
        SearchHit[] hitsHits = hits.getHits();

        ArrayList<Car> cars = new ArrayList<>();

        for (SearchHit searchHit:hitsHits){
            Car car2 = new Car();
            Map<String, HighlightField> fields = searchHit.getHighlightFields();
            HighlightField title = fields.get("carname");
            if (title==null) {
                if (searchHit.getSourceAsMap().get("carname")!=null && !"".equals(searchHit.getSourceAsMap().get("carname"))) {
                    car2.setCarname(searchHit.getSourceAsMap().get("carname").toString());
                }else {
                    car2.setCarname("大众");
                }
            } else {
                car2.setCarname(title.fragments()[0].toString());
            }
            //将其它字段一一对应放入实体中
            car2.setCarid((Integer) searchHit.getSourceAsMap().get("carid"));
            car2.setCarcolor((String) searchHit.getSourceAsMap().get("carcolor"));
            car2.setCarage((Integer)searchHit.getSourceAsMap().get("carage"));
            car2.setCarareaid((Integer)searchHit.getSourceAsMap().get("carareaid"));
            car2.setCarbrandid((Integer)searchHit.getSourceAsMap().get("carbrandid"));
            car2.setCarck((Integer) searchHit.getSourceAsMap().get("carck"));
            car2.setCarimg((String) searchHit.getSourceAsMap().get("carimg"));
            car2.setCarlc((String) searchHit.getSourceAsMap().get("carlc"));
            car2.setCarranyou((Integer) searchHit.getSourceAsMap().get("carranyou"));
            car2.setCarstatus((Integer) searchHit.getSourceAsMap().get("carstatus"));
            car2.setCarlocation((Integer) searchHit.getSourceAsMap().get("carlocation"));
            car2.setTypename((String) searchHit.getSourceAsMap().get("typename"));
            car2.setCartypeid((Integer) searchHit.getSourceAsMap().get("cartypeid"));
            car2.setTypename((String) searchHit.getSourceAsMap().get("typename"));
            car2.setCarpl((Integer) searchHit.getSourceAsMap().get("carpl"));
            car2.setCarsxj((Integer) searchHit.getSourceAsMap().get("carsxj"));
            if (searchHit.getSourceAsMap().get("carname")!=null && !"".equals(searchHit.getSourceAsMap().get("carname"))){
                car2.setCarname(searchHit.getSourceAsMap().get("carname").toString());
            }else{
                car2.setCarname("大众");
            }
            car2.setCarprice((Double) searchHit.getSourceAsMap().get("carprice"));
            cars.add(car2);
        }
        model.addAttribute("list",cars);
        return "sss/list";
    }
}
