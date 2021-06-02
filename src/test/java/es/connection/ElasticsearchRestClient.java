//package es.connection;
//
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author Jasper Liuzengyu 刘增玉
// * @version v1.0.0
// * @description
// * @date 2021/6/1
// * @since v1.0
// */
//@Configuration
//public class ElasticsearchRestClient {
//    /**
//     * ES地址,ip:port
//     */
//    @Value("${elasticsearch.ip}")
//    String ipPort;
//
//    @Bean
//    public RestClientBuilder restClientBuilder() {
//
//        return RestClient.builder(makeHttpHost(ipPort));
//    }
//
//
//    @Bean(name = "highLevelClient")
//    public RestHighLevelClient highLevelClient(@Autowired RestClientBuilder restClientBuilder) {
//        restClientBuilder.setMaxRetryTimeoutMillis(60000);
//        return new RestHighLevelClient(restClientBuilder);
//    }
//
//
//    private HttpHost makeHttpHost(String s) {
//        String[] address = s.split(":");
//        String ip = address[0];
//        int port = Integer.parseInt(address[1]);
//
//        return new HttpHost(ip, port, "http");
//    }
//}
