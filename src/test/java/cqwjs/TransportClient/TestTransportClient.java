package cqwjs.TransportClient;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/27
 * @since v1.0
 */
public class TestTransportClient {
    public static void main(String[] args) throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "myClusterName").build();

        //on startup
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
        //继续添加其他地址
        client.toString();
//        System.out.println(client.in);
        //on shutdown
        client.close();
    }
//    public static void main(String[] args) {
//        Settings settings = Settings.settingsBuilder().put("cluster.name", "elasticsearch").build();
//
//        try {
//
//            Client client = TransportClient.builder().settings(settings).build()
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
//
//            // 批量创建索引
//            BulkRequestBuilder bulkRequest = client.prepareBulk();
//            Map<String, Object> map = new HashMap<>();
//            map.put("name", "Jack");
//
//            IndexRequest request = client.prepareIndex("dept", "employee", "3433").setSource(map).request();
//            bulkRequest.add(request);
//            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
//            if (bulkResponse.hasFailures()) {
//                System.out.println("批量创建索引错误！");
//            }
//            client.close();
//            System.out.println("批量创建索引成功");
//        } catch (UnknownHostException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
