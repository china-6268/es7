//package es.connection;
//
//import org.apache.cxf.jaxrs.client.ClientConfiguration;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Autowired;
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
//public class RestClientConfigTest {
//    @Configuration
//    public class RestClientConfig extends AbstractElasticsearchConfiguration {
//
//        @Override
//        @Bean
//        public RestHighLevelClient elasticsearchClient() {
//
//            final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                    .connectedTo("localhost:9200")
//                    .build();
//
//            return RestClients.create(clientConfiguration).rest();
//        }
//
//    }
//    @Autowired
//    RestHighLevelClient highLevelClient;
//
//    RestClient lowLevelClient = highLevelClient.lowLevelClient();
//
//// ...
//
//    IndexRequest request = new IndexRequest("spring-data")
//            .id(randomID())
//            .source(singletonMap("feature", "high-level-rest-client"))
//            .setRefreshPolicy(IMMEDIATE);
//
//    IndexResponse response = highLevelClient.index(request,RequestOptions.DEFAULT);
//}
