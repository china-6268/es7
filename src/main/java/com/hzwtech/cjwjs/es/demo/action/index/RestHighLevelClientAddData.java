package com.hzwtech.cjwjs.es.demo.action.index;

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
public class RestHighLevelClientAddData {
    @Test
    public void aaa() {
        //创建链接信息
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1",9200)));

        //创建索引请求 索引名称 book
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("book-2");

        //创建索引时可以设置与之相关的 特定配置
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards",3) //分片数
                .put("index.number_of_replicas",2) //备份数
        );
        //创建文档类型映射
        createIndexRequest.mapping("{\n" +
                        "  \"properties\": {\n" +
                        "    \"id\": {\n" +
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
                        "    }\n" +
                        "  }\n" +
                        "}",
                XContentType.JSON  //类型映射，需要的是一个JSON字符串
        );
        //可选参数
        //超时,等待所有节点被确认(使用TimeValue方式)
        createIndexRequest.setTimeout(TimeValue.timeValueMinutes(1));

        try {
            //同步执行
            CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            //返回的CreateIndexResponse允许检索有关执行的操作的信息，如下所示：
            boolean acknowledged = createIndexResponse.isAcknowledged();//指示是否所有节点都已确认请求
            boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();//指示是否在超时之前为索引中的每个分片启动了必需的分片副本数
            System.out.println("acknowledged:"+acknowledged);
            System.out.println("shardsAcknowledged:"+shardsAcknowledged);
            System.out.println(createIndexResponse.index());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //关闭客户端链接
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
