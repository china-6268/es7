package com.hzwtech.cqwjs.biz.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/5
 * @since v1.0
 */
@Configuration
@Component
@ComponentScan(value = {
        "com.hzwtech.cqwjs.biz.config",
        "com.hzwtech.cqwjs.es.service"
})
@PropertySource({"classpath:application.properties"})
public class EsConfig {

    @Value("${cqwjs.elasticsearch.hostlist}")
    private String hostlist;
    @Value("${es.scheme}")
    private String scheme;

    @Bean("restHighLevelClient")
    public RestHighLevelClient restHighLevelClient() {
        /**
         * 解析 hostlist 配置信息。假如以后有多个，则需要用 ， 分开
         */
        String[] split = hostlist.split(",");
        /**
         * 创建 HttpHost 数组，其中存放es主机和端口的配置信息
         */
        HttpHost[] httpHostArray = new HttpHost[split.length];
        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            httpHostArray[i] = new HttpHost(item.split(":")[0], Integer.parseInt(item.split(":")[1]), scheme);
        }
        return new RestHighLevelClient(RestClient.builder(httpHostArray));
    }

    @Bean("restClient")
    public RestClient restClient() {
        // 解析hostlist配置信息
        String[] split = hostlist.split(",");
        // 创建HttpHost数组，其中存放es主机和端口的配置信息
        HttpHost[] httpHostArray = new HttpHost[split.length];
        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            httpHostArray[i] = new HttpHost(item.split(":")[0], Integer.parseInt(item.split(":")[1]), scheme);
        }
        return RestClient.builder(httpHostArray).build();
    }
}