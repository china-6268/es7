package es.dataadd;

import es.connection.ESUtil;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/27
 * @since v1.0
 */
public class AddData {
    public static void main(String[] args) throws Exception {
        AddData addData = new AddData();
        addData.add();
    }

    public void add() throws Exception {
        TransportClient client = ESUtil.getTransportClient();
        // 添加文档
        XContentBuilder doc = XContentFactory.jsonBuilder()
                .startObject()
                .field("id", "2")
                .field("title", "java,这是一个中文的标题")
                .field("content", "中文内容java")
                .field("postdate", "2021-05-27")
                .field("url", "http://www.hzwtech.com/12")
                .endObject();
        IndexResponse response = client.prepareIndex("cjwjs_test1", "_doc", "12")
                .setSource(doc).get();
        System.out.println(response.status());
    }
}
