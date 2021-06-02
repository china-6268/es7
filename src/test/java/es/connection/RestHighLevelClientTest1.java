package es.connection;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
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

public class RestHighLevelClientTest1 {

    public static RestHighLevelClient getHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
        return client;
    }

    @Test
    public void select1() throws IOException {

        RestHighLevelClient highLevelClient = getHighLevelClient();
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
        SearchResponse response = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
            log.info(hit.getSourceAsString());
        }
//
//
//        // 数据查询
//        GetRequest getRequest = new GetRequest();
//        RequestOptions requestOptions= new Request();
//        GetResponse response1 = client..get()prepareGet("test1", "_doc", "10").execute().actionGet();
//        GetResponse response2 = client.prepareGet("test1", "_doc", "8").execute().actionGet();
//
//        GetResponse response = client.prepareGet("cjwjs_test1", "_doc", "11").execute().actionGet();
//        GetResponse response3 = client.prepareGet("mess", "_doc", "11").execute().actionGet();
//
//        // 得到查询出的数据
//        log.info("rep3  "+response3.getSourceAsString());
//        log.info("rep2  "+response2.getSourceAsString());
//        client.close();
    }

    @Test
    public void select() throws UnknownHostException {
        RestClient restClient;
//        RestHighLevelClient client = ESUtil.getRestHighLevelClient();
//        CreateIndexRequest request = new CreateIndexRequest("twitter_two");//创建索引
//        //创建的每个索引都可以有与之关联的特定设置。
//        request.settings(Settings.builder()
//                .put("index.number_of_shards", 3)
//                .put("index.number_of_replicas", 2)
//        );
//        //创建索引时创建文档类型映射
//        request.mapping("tweet",//类型定义
//                "  {\n" +
//                        "    \"tweet\": {\n" +
//                        "      \"properties\": {\n" +
//                        "        \"message\": {\n" +
//                        "          \"type\": \"text\"\n" +
//                        "        }\n" +
//                        "      }\n" +
//                        "    }\n" +
//                        "  }",//类型映射，需要的是一个JSON字符串
//                XContentType.JSON);
//
//        //为索引设置一个别名
//        request.alias(
//                new Alias("twitter_alias")
//        );
//        //可选参数
//        request.timeout(TimeValue.timeValueMinutes(2));//超时,等待所有节点被确认(使用TimeValue方式)
//        //request.timeout("2m");//超时,等待所有节点被确认(使用字符串方式)
//
//        request.masterNodeTimeout(TimeValue.timeValueMinutes(1));//连接master节点的超时时间(使用TimeValue方式)
//        //request.masterNodeTimeout("1m");//连接master节点的超时时间(使用字符串方式)
//
//        request.waitForActiveShards(2);//在创建索引API返回响应之前等待的活动分片副本的数量，以int形式表示。
//        //request.waitForActiveShards(ActiveShardCount.DEFAULT);//在创建索引API返回响应之前等待的活动分片副本的数量，以ActiveShardCount形式表示。
////同步执行
//        CreateIndexResponse createIndexResponse = client.indices().create(request);
//        //异步执行
//        //异步执行创建索引请求需要将CreateIndexRequest实例和ActionListener实例传递给异步方法：
//        //CreateIndexResponse的典型监听器如下所示：
//
//        client.indices().createAsync(request, listener);//要执行的CreateIndexRequest和执行完成时要使用的ActionListener
//
//        //返回的CreateIndexResponse允许检索有关执行的操作的信息，如下所示：
//        boolean acknowledged = createIndexResponse.isAcknowledged();//指示是否所有节点都已确认请求
//        boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();//指示是否在超时之前为索引中的每个分片启动了必需的分片副本数
    }
}