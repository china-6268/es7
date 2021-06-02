package es.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/27
 * @since v1.0
 */
public class InitDemo {

    public static RestHighLevelClient getClient() {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));
        return client;
    }
//    public static void aa(){
//        Client client = TransportClient.builder().build()
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host1"), 9300))
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));
//    }
//    public static Client getClient() {
//
//        Client client = new Client(
//                RestClient.builder(new HttpHost("localhost", 9200, "http"),
//                        new HttpHost("localhost", 9201, "http")));
//        return client;
//    }
}
