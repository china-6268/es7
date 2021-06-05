package com.hzwtech.cqwjs.biz.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.PropertyKey;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/5
 * @since v1.0
 */

public class PdfBean extends BookBean {
    private static final long serialVersionUID = 2699122062675445396L;

    public PdfBean() {
        System.out.println("PdfBean类的构造方法...");
    }

    public void init() {
        System.out.println("PdfBean的init()方法...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("PdfBean的postConstruct()方法...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PdfBean的preDestroy()方法...");
    }

    @Override
    public void destroy() {
        System.out.println("PdfBean的destroy()方法...");
    }
}
