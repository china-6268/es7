package es.query.mget;

import es.connection.ESUtil;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/28
 * @since v1.0
 */
public class MultiGetData {
    @Test
    public void mget() throws Exception {
        TransportClient client = ESUtil.getTransportClient();
        MultiGetResponse responses = client.prepareMultiGet()
                .add("test1", "_doc", "8", "10", "7", "9")
                .add("lib3", "user", "2", "3").add("cjwjs_test1", "_doc", "10", "12", "11")
                .get();
        for (MultiGetItemResponse respons : responses) {
            GetResponse response = respons.getResponse();
            if (response != null && response.isExists()) {
                System.out.println(response.getSourceAsString());
            }
        }
    }
}
