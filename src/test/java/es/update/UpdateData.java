package es.update;

import es.connection.ESUtil;
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
public class UpdateData {
    @Test
    public void update() throws Exception {
        TransportClient client = ESUtil.getTransportClient();

        // 更新文档
        UpdateRequest request = new UpdateRequest();
        request.index("cjwjs_test1")
                .type("_doc")
                .id("11")
                .doc(
                        XContentFactory.jsonBuilder().startObject()
                                .field("title", "java设计模式")
                                .endObject()
                );
        UpdateResponse response = client.update(request).get();
        System.out.println(response.status());
    }

}
