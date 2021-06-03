package es.connection;

import com.hzwtech.cqwjs.es.client.EsClientImpl;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/1
 * @since v1.0
 */
@Slf4j
public class BuildClientTest {
    //    private RestHighLevelClient buildClient() {
//        SniffOnFailureListener sniffOnFailureListener = new SniffOnFailureListener();
//        RestClientBuilder restClientBuilder = restClientBuilder();
//        restClientBuilder.setFailureListener(sniffOnFailureListener);
//        if (!StringUtils.isEmpty(user) && !StringUtils.isEmpty(password)) {
//            applyAuthentication(restClientBuilder, user, password);
//        }
//        restHighLevelClient = new RestHighLevelClient(restClientBuilder);
//        Sniffer sniffer = Sniffer.builder(restHighLevelClient.getLowLevelClient())
//                .setSniffIntervalMillis(30000).build();
//        sniffOnFailureListener.setSniffer(sniffer);
//        return restHighLevelClient;
//    }
//    @Resource(type = EsClientImpl.class)
    @Autowired
    EsClientImpl esClient;

    @Test
    public void testEsClient() throws IOException {
        RestHighLevelClient restHighLevelClient = esClient.getRestHighLevelClient();
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("test1");
//        searchRequest.types("_doc");
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("title", "中文");
        QueryBuilder totalFilter = QueryBuilders.boolQuery()
                .filter(matchQuery);
//                .filter(timeFilter)
//                .mustNot(termQuery);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(totalFilter);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
//        RequestOptions requestOptions = RequestOptions.Builder();
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
            log.info(hit.getSourceAsString());
        }
    }

}