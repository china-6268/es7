package com.hzwtech.cqwjs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.hzwtech.cqwjs.biz.config",
        "com.hzwtech.cqwjs.biz.config.impl",
        "com.hzwtech.cqwjs.es.service",
        "com.hzwtech.cqwjs.es.service.impl"})
public class CqwjsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CqwjsApplication.class, args);
    }

    @Value("${es.indexName}")
    private String indexName;
    @Value("${server.port}")
    private int port;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("es.indexName is " + indexName);
        System.out.println("Environment port is " + port);
    }
}
