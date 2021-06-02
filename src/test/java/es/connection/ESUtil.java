package es.connection;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
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
public class ESUtil {
    private static volatile TransportClient client;

    //    /**
//     * 采用双端检索机制实现客户端为单例模式
//     *
//     * @param clusterName 你的Elasticsearch集群名称
//     * @param hostName    你的Elasticsearch的主机Ip地址
//     * @param hostPort    你的Elasticsearch与客户端通信的端口，一般为9300
//     * @return TransportClient
//     * @throws UnknownHostException
//     */
//    @SuppressWarnings("resource")
//    public static TransportClient getClient(String clusterName, String hostName, int hostPort) {
//        if (client == null) {
//            synchronized (TransportClient.class) {
//                try {
//                    client = new PreBuiltTransportClient(Settings.builder().put("cluster.name", clusterName).build())
//                            .addTransportAddress(new TransportAddress(InetAddress.getByName(hostName), hostPort));
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return client;
//    }
//
//    public static TransportClient getClient(String hostName, int hostPort) {
//        if (client == null) {
//            synchronized (TransportClient.class) {
//                try {
//                    client = new PreBuiltTransportClient(Settings.builder().put("cluster.name", "cjwjs_es_cluster").build())
//                            .addTransportAddress(new TransportAddress(InetAddress.getByName(hostName), hostPort));
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return client;
//    }
    public static RestHighLevelClient getRestHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "my-application"),
                        new HttpHost("localhost", 9300, "my-application")));
        return client;
    }

    public static TransportClient getTransportClient() throws UnknownHostException {
//        RestClient restClient = new RestClient.ContentCompressingEntity("");
        // 指定es集群
        Settings settings = Settings.builder().put("cluster.name", "my-application").build();
//        Client client = new TransportClient()
//                .addTransportAddress(new InetSocketTransportAddress(
//                        "143.79.236.xxx",
//                        9300));
//        RestClientBuilder restClientBuilder;
//        RestHighLevelClient restHighLevelClient  = new RestHighLevelClient(restClientBuilder.)


        // 创建访问es服务器的客户端
        return new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }
}