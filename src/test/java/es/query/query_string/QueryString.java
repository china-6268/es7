package es.query.query_string;

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
public class QueryString {
    @Test
    public void queryString() throws UnknownHostException, UnknownHostException {
        TransportClient client = ESUtil.getTransportClient();

        // 查询某个字段
//        QueryBuilder build = QueryBuilders.commonTermsQuery("name","tom");
        // 查询所有字段 +号表示含有 -号表示不含有
//        QueryBuilder build = QueryBuilders.queryStringQuery("+喝酒 -跳舞");
        QueryBuilder build = QueryBuilders.simpleQueryStringQuery("+java");

        SearchResponse response = client.prepareSearch("test1")
                .setQuery(build)
                .get();
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
}
