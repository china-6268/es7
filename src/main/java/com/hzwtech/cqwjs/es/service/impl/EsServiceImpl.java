package com.hzwtech.cqwjs.es.service.impl;

import com.hzwtech.cqwjs.es.service.EsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
//    @Resource
//    private EsConfig esConfig;
//
//    public EsServiceImpl(EsConfig esConfig) {
//        this.esConfig = esConfig;
//    }

    @Override
    public String deal() {
//        RestHighLevelClient restHighLevelClient = esConfig.restHighLevelClient();
//        log.info("restHighLevelClient: " + String.valueOf(restHighLevelClient));
//        return restHighLevelClient.toString();
        return "";
    }
}
