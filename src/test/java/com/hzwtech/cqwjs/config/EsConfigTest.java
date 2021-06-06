package com.hzwtech.cqwjs.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/5
 * @since v1.0
 */
@ActiveProfiles("test")
public class EsConfigTest {
//    @Autowired
//    private Environment env;
//    @Autowired
//    EsConfig esConfig;

//    @PostConstruct
//    public void setupEsConfig() {
//        esConfig.restHighLevelClient();
//    }

    @Value("${spring.profiles.active}")
    private String env;

    @Value("${server.port}")
    private int port;

    @Test
    public void esConfigTest1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        System.err.println("env: " + env + ", port " + port);

//        context.getEnvironment().setActiveProfiles(env);
//        context.register(EsConfigProdImpl.class);
        context.refresh();
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EsConfig.class);
//        EsService esService = context.getBean(EsServiceImpl.class);
//        System.err.println("esService:\t"+esService.deal());
    }


    //    @PostUpdate
    @Test
    public void afterUpdate1() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//        String[] activeProfile = env.getActiveProfiles();
//        System.err.println("activeProfile "+activeProfile);

    }
}
