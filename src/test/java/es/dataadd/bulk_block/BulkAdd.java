package es.dataadd.bulk_block;

import es.connection.ESUtil;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
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
public class BulkAdd {
    @Test
    // 批量添加
    public void bulk() throws Exception {
        TransportClient client = ESUtil.getTransportClient();
        BulkRequestBuilder bulkrequestbuilder = client.prepareBulk();
        // 批量添加
        bulkrequestbuilder.add(client.prepareIndex("test1", "_doc", "7")
                .setSource(
                        XContentFactory.jsonBuilder()
                                .startObject()
                                .field("id", "3")
                                .field("title", "python")
                                .field("content", "content")
                                .field("postdate", "2020-01-23")
                                .field("url", "www.baidu.com")
                                .endObject()
                )
        );
        bulkrequestbuilder.add(client.prepareIndex("test1", "_doc", "9")
                .setSource(
                        XContentFactory.jsonBuilder()
                                .startObject()
                                .field("id", "5")
                                .field("title", "fullter")
                                .field("content", "content")
                                .field("postdate", "2020-01-23")
                                .field("url", "www.ali.com")
                                .endObject()
                )
        );
        BulkResponse bulkItemResponses = bulkrequestbuilder.get();
        System.out.println(bulkItemResponses.status());
        if (bulkItemResponses.hasFailures()) {
            System.out.println("失败");
        }
    }
}