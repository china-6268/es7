package com.hzwtech.cjwjs.es.demo.action.add;

import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
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
public class IndexAddDocs {
    @Test
    public void aaa() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200)));
        //创建请求， 参数index名称
        IndexRequest request = new IndexRequest("book-index");
        //请求的模式，CREATE： 创建模式，如果已经存在则报错   Index:存在则不再创建，也不报错
        request.opType(DocWriteRequest.OpType.INDEX);
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"userId\": \"17\",\n" +
                "  \"name\": \"语文就是回回考100分\",\n" +
                "  \"price\": \"23\"\n" +
                "}";
        request.id("1").source(
                json,
                XContentType.JSON
        );
        IndexResponse indexResponse = null;
        try {
            //调用 index 方法
            indexResponse = client.index(request, RequestOptions.DEFAULT);
            System.out.println(indexResponse.getVersion());
            System.out.println(indexResponse.getIndex());
            System.out.println(indexResponse.getId());
            System.out.println(indexResponse.status());
        } catch (ElasticsearchStatusException | IOException e) {
            e.printStackTrace();
        }

    }
}
