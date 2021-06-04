package com.hzwtech.cqwjs.es.demo.action.index;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
@Slf4j
public class CreateIndex {
    private String getJsonString() {
        String json = "{\n" +
                "  \"dynamic\": true,\n" +
                "  \"properties\": {\n" +
                "    \"id\": {\n" +
                "      \"type\": \"long\",\n" +
                "      \"store\": true\n" +
                "    },\n" +
                "    \"userId\": {\n" +
                "      \"type\": \"long\",\n" +
                "      \"store\": true\n" +
                "    },\n" +
                "    \"name\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"index\": true,\n" +
                "      \"analyzer\": \"ik_max_word\"\n" +
                "    },\n" +
                "    \"content\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"index\": true,\n" +
                "      \"analyzer\": \"ik_max_word\"\n" +
                "    },\n" +
                "    \"title\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"index\": true,\n" +
                "      \"analyzer\": \"ik_max_word\"\n" +
                "    },\n" +
                "    \"summary\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"index\": true,\n" +
                "      \"analyzer\": \"ik_max_word\"\n" +
                "    },\n" +
                "    \"description\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"index\": true,\n" +
                "      \"analyzer\": \"ik_max_word\"\n" +
                "    },\n" +
                "    \"key_word\": {\n" +
                "      \"type\": \"keyword\",\n" +
                "      \"ignore_above\" : 256,\n" +
                "      \"index\": true\n" +
                "    },\n" +
                "    \"author\": {\n" +
                "      \"type\": \"keyword\",\n" +
                "      \"ignore_above\" : 256,\n" +
                "      \"index\": true\n" +
                "    },\n" +
                "    \"price\": {\n" +
//                "      \"type\": \"unsigned_long\",\n" +
                "      \"type\": \"double\",\n" +
                "      \"index\": true,\n" +
                "      \"store\": true\n" +
                "    },\n" +
                "    \"status\": {\n" +
                "      \"type\": \"integer\",\n" +
                "      \"index\": true,\n" +
                "      \"store\": true\n" +
                "    },\n" +
                "    \"is_deleted\": {\n" +
                "      \"type\": \"short\",\n" +
                "      \"index\": true,\n" +
                "      \"store\": true\n" +
                "    },\n" +
                "    \"gmt_created\": {\n" +
                "      \"type\": \"date\",\n" +
                "      \"index\": true,\n" +
                "      \"store\": true\n" +
                "    },\n" +
                "    \"gmt_updated\": {\n" +
                "      \"type\": \"date\",\n" +
                "      \"index\": true,\n" +
                "      \"store\": true\n" +
                "    }\n" +
                "  }\n" +
                "}";
        return json;
    }

    @Test
    public void doCreateIndex() {
        String indexName = "book_index_demo";
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200)));
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        createIndexRequest.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
        createIndexRequest.mapping(getJsonString(), XContentType.JSON
        );
        createIndexRequest.setTimeout(TimeValue.timeValueMinutes(1000));
        try {
            //同步执行
            CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            boolean acknowledged = createIndexResponse.isAcknowledged();//指示是否所有节点都已确认请求
            boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();//指示是否在超时之前为索引中的每个分片启动了必需的分片副本数
            System.err.println("acknowledged:" + acknowledged);
            System.err.println("shardsAcknowledged:" + shardsAcknowledged);
            System.err.println("createIndexResponse.index()= " + createIndexResponse.index());
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        try {
            client.close();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
    }
}