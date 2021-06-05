package com.hzwtech.cqwjs.es.demo.util;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/5
 * @since v1.0
 */
public class GetDataTest {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(MainConfig1.class);
        context.refresh();

        EsUtil dbConfig = context.getBean(EsUtil.class);
        System.out.println(dbConfig);
    }
}
