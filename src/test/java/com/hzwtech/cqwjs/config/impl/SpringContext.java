//package com.hzwtech.cqwjs.config.impl;
//
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
///**
// * @author Jasper Liuzengyu 刘峻华
// * @version v1.0.0
// * @description
// * @date 2021/6/6
// * @since v1.0
// */
//@Component
//public class SpringContext
//{
//    private static Environment environment;
//
//    public SpringContext(Environment environment) {
//        SpringContext.environment = environment;
//    }
//
//    public static Environment getEnvironment() {
//        if (environment == null) {
//            throw new RuntimeException("Environment has not been set yet");
//        }
//        return environment;
//    }
//}