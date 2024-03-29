package com.hzwtech.cqwjs.es.demo.action.add;

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
public class AddOrUpdateDocs {
    @Test
    public void doIndexAddOrUpdateDocs() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200)));
        //创建请求， 参数index名称
        IndexRequest request = new IndexRequest("book_index_demo");
        //请求的模式，CREATE： 创建模式，如果已经存在则报错   Index:存在则不再创建，也不报错
        request.opType(DocWriteRequest.OpType.INDEX);
        String json = "{\n" +
                "  \"id\": 3,\n" +
                "  \"userId\": 3,\n" +
                "  \"name\": \"英语超霸\",\n" +
                "  \"content\": \"英语考试从来100分\",\n" +
                "  \"gmt_created\":  \"2021-06-05\",\n" +
                "  \"gmt_modified\":  \"2021-06-05\",\n" +
                "  \"is_deleted\":  0,\n" +
                "  \"status\":  0,\n" +
                "  \"key_word\":  \"英语\",\n" +
                "  \"price\": 66.66\n"  +
                "}";
        request.id("3").source(
                json,
                XContentType.JSON
        );
        try {
            //调用 index 方法
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            System.err.println(indexResponse.getVersion());
            System.out.println(indexResponse.getIndex());
            System.out.println(indexResponse.getId());
            System.err.println(indexResponse.status());
        } catch (ElasticsearchStatusException | IOException e) {
            e.printStackTrace();
        }

    }
}
