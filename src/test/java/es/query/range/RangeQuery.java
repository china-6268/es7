package es.query.range;

import es.connection.ESUtil;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;

import java.util.Map;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/28
 * @since v1.0
 */
public class RangeQuery {
    @Test
    public void range() throws Exception {
        TransportClient client = ESUtil.getTransportClient();

        // 范围range查询
//        QueryBuilder builder = QueryBuilders.rangeQuery("postdate").from("2020-01-10").to("2020-01-15").format("yyyy-MM-dd");
        // prefix查询
//        QueryBuilder builder = QueryBuilders.prefixQuery("title","java");
        // 通配符wildcard查询
//        QueryBuilder builder = QueryBuilders.wildcardQuery("title","java*");
        // 模糊查询
//        QueryBuilder builder = QueryBuilders.fuzzyQuery("title","j");
        //type查询
//        QueryBuilder builder = QueryBuilders.typeQuery("_doc");
        // ids查询
        QueryBuilder builder = QueryBuilders.idsQuery().addIds("8", "9");
        SearchResponse response = client.prepareSearch("test1")
                .setQuery(builder)
                .get();

        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            for (String key : sourceAsMap.keySet()) {
                System.out.println(key + "=" + sourceAsMap.get(key));
            }
        }
    }
}