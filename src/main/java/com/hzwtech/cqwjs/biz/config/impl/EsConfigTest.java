package com.hzwtech.cqwjs.biz.config.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/6
 * @since v1.0
 */
public class EsConfigTest {
    @Autowired
    ConfigurableEnvironment configurableEnvironment;
    @Test
    public void getActiveProfiles() {
        System.err.println(configurableEnvironment);
//        for (final String profileName : configurableEnvironment.getActiveProfiles()) {
//            System.out.println("Currently active profile - " + profileName);
//        }
    }
}
