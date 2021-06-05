package com.hzwtech.cqwjs.config;

import com.hzwtech.cqwjs.biz.config.EsConfig;
import com.hzwtech.cqwjs.es.service.EsService;
import com.hzwtech.cqwjs.es.service.impl.EsServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/5
 * @since v1.0
 */
public class EsConfigTest {
    @Test
    public void esConfigTest1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EsConfig.class);
        EsService esService = context.getBean(EsServiceImpl.class);
        System.err.println("esService:\t"+esService.deal());

    }
}
