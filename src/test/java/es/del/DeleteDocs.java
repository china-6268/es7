package es.del;

import es.connection.ESUtil;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/28
 * @since v1.0
 */
public class DeleteDocs {
    @Test
    public void delete() throws Exception {
        TransportClient client = ESUtil.getTransportClient();
        // 删除文档
        DeleteResponse response1 = client.prepareDelete("test1", "_doc", "10").get();
        DeleteResponse response = client.prepareDelete("cjwjs_test1", "_doc", "11").get();

        System.out.println(response1.status());
        System.out.println(response.status());
    }
}