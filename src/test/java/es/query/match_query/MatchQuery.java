package es.query.match_query;

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
public class MatchQuery {
    @Test
    // 查询某个字段
    public void match() throws Exception {
        TransportClient client = ESUtil.getTransportClient();
        QueryBuilder builder = QueryBuilders.matchQuery("content", "伊拉克");
        SearchResponse response = client.prepareSearch("index")
                .setQuery(builder)
                .setSize(3)
                .get();

        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            for (String key : sourceAsMap.keySet()) {
                System.out.println(key + " = " + sourceAsMap.get(key));
            }
        }
    }
}
