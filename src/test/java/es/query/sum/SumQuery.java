package es.query.sum;

import es.connection.ESUtil;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.Cardinality;
import org.junit.Test;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/28
 * @since v1.0
 */
public class SumQuery {
    @Test
    public void sum() throws Exception {
        TransportClient client = ESUtil.getTransportClient();
//        AggregationBuilder agg = AggregationBuilders.max("aggMax").field("age");
//        SearchResponse response = client.prepareSearch("lib3").addAggregation(agg).get();
//        Max aggMax = response.getAggregations().get("aggMax");
//        System.out.println(aggMax.getValue());

//        AggregationBuilder agg = AggregationBuilders.min("aggMin").field("age");
//        SearchResponse response = client.prepareSearch("lib3").addAggregation(agg).get();
//        Min aggMax = response.getAggregations().get("aggMin");
//        System.out.println(aggMax.getValue());

        // 求基数
        AggregationBuilder agg = AggregationBuilders.cardinality("java").field("title");
        SearchResponse response = client.prepareSearch("test1").addAggregation(agg).get();
        Cardinality cardinality = response.getAggregations().get("java");
        System.out.println(cardinality.getValue());
    }
}