package es.query;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
public class RestHighLevelClientQueryData {
    @Test
    public void aaa() {
        RestClientBuilder builder = RestClient.builder(
                new HttpHost(
                        "127.0.0.1",  //es主机 IP
                        9200   // es 端口http
                )
        );
        RestHighLevelClient client = new RestHighLevelClient(builder);
        GetRequest request = new GetRequest(
                "blog1", //索引
                "1" //文档ID
        );

        //当针对不存在的索引执行获取请求时，响应404状态码，将引发IOException，需要按如下方式处理：
        GetResponse documentFields = null;
        try {
            documentFields = client.get(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            ////处理因为索引不存在而抛出的异常情况
        }
        System.out.println(documentFields);
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
