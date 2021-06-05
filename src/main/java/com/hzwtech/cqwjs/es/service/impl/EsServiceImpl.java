package com.hzwtech.cqwjs.es.service.impl;

import com.hzwtech.cqwjs.biz.config.EsConfig;
import com.hzwtech.cqwjs.es.service.EsService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/5
 * @since v1.0
 */
@Service
@Slf4j
public class EsServiceImpl implements EsService {
    @Resource(name = "esConfig")
    private EsConfig esConfig;

    @Override
    public String deal() {
        RestHighLevelClient restHighLevelClient = esConfig.restHighLevelClient();
        log.info("restHighLevelClient: " + String.valueOf(restHighLevelClient));
        return restHighLevelClient.toString();
    }
}
