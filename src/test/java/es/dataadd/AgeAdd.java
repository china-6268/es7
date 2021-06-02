package es.dataadd;

import es.connection.ESUtil;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/29
 * @since v1.0
 */
public class AgeAdd {
    @Test
    public void ageAdd() throws IOException {
        TransportClient client = ESUtil.getTransportClient();
        // 添加文档
        XContentBuilder doc = XContentFactory.jsonBuilder()
                .startObject()
                .field("id", "3")
                .field("title", "age年龄1")
                .field("content", "年龄起点1")
                .field("postdate", "2021-05-29")
                .field("age", 20).field("average_balance", 10)
                .endObject();
        IndexResponse response = client.prepareIndex("test2", "_doc", "3")
                .setSource(doc).get();
        System.out.println(response.status());
    }
}
