package es.dataadd.upsert_added;

import es.connection.ESUtil;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/28
 * @since v1.0
 */
public class SupplementData {
    @Test
    public void upsert() throws Exception {
        TransportClient client = ESUtil.getTransportClient();
        // 添加文档
        IndexRequest request1 = new IndexRequest("test1", "_doc", "8")
                .source(
                        XContentFactory.jsonBuilder()
                                .startObject()
                                .field("id", "2")
                                .field("title", "html标题1")
                                .field("content", "中文内容java")
                                .field("postdate", "2020-01-13")
                                .field("summary", "https://blog.csdn.net/yanyf2016")
                                .endObject()
                );
        UpdateRequest request2 = new UpdateRequest("test1", "_doc", "8")
                .doc(
                        XContentFactory.jsonBuilder().startObject()
                                .field("title", "java模式1").field("note", "note1...")
                                .endObject()
                ).upsert(request1);
        UpdateResponse response = client.update(request2).get();
        System.out.println(response.status());
    }

}
