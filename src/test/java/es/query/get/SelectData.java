package es.query.get;

import com.hzwtech.cqwjs.biz.config.HighLevelClient;
import es.connection.ESUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/27
 * @since v1.0
 */
@Slf4j
public class SelectData {
    @Test
    public void select() throws UnknownHostException {
        TransportClient client = ESUtil.getTransportClient();
        // 数据查询
        GetResponse response1 = client.prepareGet("test1", "_doc", "10").execute().actionGet();
        GetResponse response2 = client.prepareGet("test1", "_doc", "8").execute().actionGet();

        GetResponse response = client.prepareGet("cjwjs_test1", "_doc", "11").execute().actionGet();
        GetResponse response3 = client.prepareGet("mess", "_doc", "11").execute().actionGet();

        // 得到查询出的数据
//        System.out.println();
//        System.out.println(response1.getSourceAsString());
//        System.out.println();
//        System.out.println(response2.getSourceAsString());
//        System.err.println("aaaaaaaaa***********");
//        System.out.println(response3.getSourceAsString());
        log.info("rep3  " + response3.getSourceAsString());
        log.info("rep2  " + response2.getSourceAsString());
//        System.err.println("bbbbbbbbbb***********");
        //        logger.info(response1.getSourceAsString());
        //        System.out.println(response.getSourceAsString());
        client.close();
    }

    private void myMethod() {
        RequestOptions.Builder requestOptionsBuilder = null;
        RequestOptions r =
                requestOptionsBuilder.build();
    }

    @Test
    public void select1() throws IOException {
        RestHighLevelClient highLevelClient = HighLevelClient.getHighLevelClient();
        // 数据查询
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("test1");
        searchRequest.types("_doc");
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("title", "中文");
        QueryBuilder totalFilter = QueryBuilders.boolQuery()
                .filter(matchQuery);
//                .filter(timeFilter)
//                .mustNot(termQuery);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(totalFilter);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        SearchResponse response = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.err.println(hit.getSourceAsString());
            log.info(hit.getSourceAsString());
        }
        highLevelClient.close();
    }
}