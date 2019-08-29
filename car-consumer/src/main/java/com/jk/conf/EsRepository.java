package com.jk.conf;

import com.jk.elastic.Car;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author ： 未振华
 * @date ：Created in 2019/8/28 16:47
 * @description：
 * @package ：com.jk.conf
 * @version:
 */
public interface EsRepository extends ElasticsearchRepository<Car,Integer> {


}
