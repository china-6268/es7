package com.hzwtech.cqwjs.es.demo.action.query;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
public class GetData {
    @Test
    public void doQueryData() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200)));
        GetRequest request = new GetRequest("book-1");
        // 为特定字段 配置  源包含
        String[] includs = {"name", "id", "content","userId","buyDate"};
        String[] excluds = {
//                "id"
        };
        FetchSourceContext context = new FetchSourceContext(true, includs, excluds);
        request.id("1").fetchSourceContext(context);
        try {
            GetResponse documentFields = client.get(request, RequestOptions.DEFAULT);
            if (documentFields.isExists()) {
                //检索名称
                System.out.println(documentFields.getIndex());
                // 获取文档源的 Map 结果
                System.err.println(documentFields.getSource());
                // 获取源作为 Map
//                System.err.println(documentFields.getSourceAsMap());
                // 获取源作为 bytes
                System.out.println(documentFields.getSourceAsBytes());
            } else {
                System.out.println("不错在该数据");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}