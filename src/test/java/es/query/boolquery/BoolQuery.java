package es.query.boolquery;

import es.connection.ESUtil;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;

import java.net.UnknownHostException;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/28
 * @since v1.0
 */
public class BoolQuery {
    @Test
    // 组合查询
    public void boolquery() throws UnknownHostException, UnknownHostException {
        TransportClient client = ESUtil.getTransportClient();
//        QueryBuilder build = QueryBuilders.boolQuery()
//                            .must(QueryBuilders.matchQuery("interests","唱歌"))
//                            .mustNot(QueryBuilders.matchQuery("interests","跳舞"))
//                            .should(QueryBuilders.matchQuery("address","china"))
//                            .filter(QueryBuilders.rangeQuery("birthday").gte("2019-01-01").format("yyyy-MM-dd"));
        // 不计算相关度分数
        QueryBuilder build = QueryBuilders.constantScoreQuery(QueryBuilders.termQuery("name", "java"));
        SearchResponse response = client.prepareSearch("test1")
                .setQuery(build)
                .get();
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
}
