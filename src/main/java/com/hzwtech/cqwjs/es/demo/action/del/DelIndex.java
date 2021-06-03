package com.hzwtech.cqwjs.es.demo.action.del;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
public class DelIndex {
    @Test
    public void aa(){
        //1. 创建客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1",9200)));
        //2. 创建DeleteIndexRequest 接受 index(索引名) 参数
        DeleteIndexRequest request = new DeleteIndexRequest("book-1");
        //超时以等待所有节点确认索引删除 参数为 TimeValue 类型
        request.timeout(TimeValue.timeValueMinutes(1));
        //连接master节点的超时时间(使用TimeValue方式)
        request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
        try {
            // 调用delete
            AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
            System.out.printf("isAcknowledged:%s", response.isAcknowledged());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
