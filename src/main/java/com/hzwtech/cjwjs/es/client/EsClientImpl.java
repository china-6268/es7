package com.hzwtech.cjwjs.es.client;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */

@Service
@Configurable
@Data
@Slf4j
public class EsClientImpl implements EsClient {
    private static final long INITIALIZATION_TIMEOUT = 1000;
    private static final long INITIALIZATION_RETRY_WAIT = 1000;
    private static final Object TAG = new Object();
    private static final RestHighLevelClient HEADERS = null;
    private String host = "localhost";
    private int port = 9200;
    //    private String scheme = "my-application";
    private String scheme = "http";

    public EsClientImpl() {
    }

    public EsClientImpl(String host, int port, String scheme) {
        host = this.host;
        port = this.port;
        scheme = this.scheme;
    }

    /**
     * @param host
     * @param port
     * @param scheme
     * @return
     */
    @Override
    public RestHighLevelClient getRestHighLevelClient(String host, int port, String scheme) {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(this.host, this.port, this.scheme)));
    }

    @Override
    public RestHighLevelClient getRestHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(this.host, this.port, this.scheme)));
        return client;
    }

    private boolean waitForConnection(RestHighLevelClient client) {
        long timeout = System.currentTimeMillis() + INITIALIZATION_TIMEOUT;
        while (System.currentTimeMillis() < timeout) {
            try {
                ClusterHealthResponse response = client.cluster().health(new ClusterHealthRequest(), RequestOptions.DEFAULT);
                log.debug("ElasticSearch cluster (%s) status is %s.", response.getClusterName(), response.getStatus());
                // If ElasticSearch is reachable and its status is at least 'yellow' return immediately.
                if (response.status() == RestStatus.OK && response.getStatus() != ClusterHealthStatus.RED) {
                    return true;
                }
            } catch (ElasticsearchException | IOException ex) {
                log.error(ex.getMessage());
            }
            try {
                Thread.sleep(INITIALIZATION_RETRY_WAIT);
            } catch (InterruptedException ignored) {
                // Re-interrupt thread and return immediately in order to trigger a component shutdown.
                Thread.currentThread().interrupt();
                return false;
            }
            log.warn("ElasticSearch cluster is not available. Trying again.");
        }
        return false;
    }
}