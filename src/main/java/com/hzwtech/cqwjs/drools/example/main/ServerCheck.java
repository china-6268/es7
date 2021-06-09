package com.hzwtech.cqwjs.drools.example.main;

import com.hzwtech.cqwjs.drools.example.model.Server;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/9
 * @since v1.0
 */
@Slf4j
public class ServerCheck {
    private KieServices kieServices=KieServices.Factory.get();
//    @Test
    public  void main1(
//            String[] args
    ) {
//        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        log.info("Creating kieBase");
        KieBase kieBase = kContainer.getKieBase();
        log.info("There should be rules: ");
        for (KiePackage kp : kieBase.getKiePackages()) {
            for (Rule rule : kp.getRules()) {
                System.err.println("kp " + kp + " rule " + rule.getName());
//                LOG.info("kp " + kp + " rule " + rule.getName());
            }
        }
        log.info("Creating kieSession");
        KieSession session = kieBase.newKieSession();
        log.info("Now running data");
        Server s1 = new Server("rhel7 ", 2, 102, 2048);
        session.insert(s1);
        session.fireAllRules();

        Server s2 = new Server("rhel8 ", 2, 204, 409);
        session.insert(s2);
        session.fireAllRules();
    }

    @Test
    public  void serverCheckAction() {
//        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        log.info("Creating kieBase");
        KieBase kieBase = kContainer.getKieBase();
        log.info("There should be rules: ");
        for (KiePackage kp : kieBase.getKiePackages()) {
            for (Rule rule : kp.getRules()) {
                System.err.println("kp " + kp + " rule " + rule.getName());
            }
        }
        log.info("Creating kieSession");
        KieSession session = kieBase.newKieSession();
        log.info("Now running data");
        Server s1 = new Server("rhel7 ", 2, 102, 2048);
        session.insert(s1);
        session.fireAllRules();

        Server s2 = new Server("rhel8 ", 2, 204, 409);
        session.insert(s2);
        session.fireAllRules();
    }
}