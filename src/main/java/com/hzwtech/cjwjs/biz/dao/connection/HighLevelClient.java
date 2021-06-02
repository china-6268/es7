package com.hzwtech.cjwjs.biz.dao.connection;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/1
 * @since v1.0
 */
public class HighLevelClient {
    public static RestHighLevelClient getHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
        return client;
    }

    public static RestHighLevelClient getHighLevelClient(String host, int port) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host, port, "http")));
        return client;
    }

    public static RestHighLevelClient getHighLevelClient(String host, int port, String scheme) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host, port, scheme)));
        return client;
    }

    public static RestHighLevelClient getHighLevelClient(String scheme) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, scheme)));
        return client;
    }

    public static RestHighLevelClient getHighLevelClient(int port) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", port, "http")));
        return client;
    }
}