package com.hzwtech.cjwjs.es.client;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
public interface EsClient {

    public RestHighLevelClient getRestHighLevelClient(String host, int port, String scheme);

    public RestHighLevelClient getRestHighLevelClient();
}
