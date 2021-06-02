package es.model;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/27
 * @since v1.0
 */
public class PersonModule {
    private static final String HOST = "localhost";
    private static final int PORT_ONE = 9200;
    private static final int PORT_TWO = 9201;
    private static final String SCHEME = "http";
    private static final String INDEX = "persondata";
//    private static ObjectMapper objectMapper = new ObjectMapper();
    private static final String TYPE = "_doc";
    private static RestHighLevelClient restHighLevelClient;

}
