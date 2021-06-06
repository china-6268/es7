package com.hzwtech.cqwjs.biz.config;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/6
 * @since v1.0
 */
public interface EsConfig {

    RestHighLevelClient restHighLevelClient();

    RestClient restClient();
}
