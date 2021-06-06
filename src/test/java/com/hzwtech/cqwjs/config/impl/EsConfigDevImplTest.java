//package com.hzwtech.cqwjs.config.impl;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.core.env.Environment;
//
///**
// * @author Jasper Liuzengyu 刘峻华
// * @version v1.0.0
// * @description
// * @date 2021/6/6
// * @since v1.0
// */
//public class EsConfigDevImplTest implements EnvironmentAware {
////    @Value("${spring.profiles.active}")
////    private String env;
//@Value("${spring.profiles.active}")
//private String activeProfile;
//
////    @Autowired
////    Environment env;
//
//    @Test
//    public void esConfigTest1() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        System.err.println("env: " +" activeProfile "+activeProfile);
////        context.getEnvironment().setActiveProfiles(env);
////        context.register(EsConfigProdImpl.class);
////        context.refresh();
////        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EsConfig.class);
////        EsService esService = context.getBean(EsServiceImpl.class);
////        System.err.println("esService:\t" + esService.deal());
//    }
//
//    @Override
//    public void setEnvironment(Environment environment) {
//
//    }
//}
