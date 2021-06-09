package drools.verity;

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
    private KieServices kieServices = KieServices.Factory.get();

    @Test
    public void main1(
    ) {
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        log.info("Creating kieBase");

        KieBase kieBase = kContainer.getKieBase("server_config_check");
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

    @Test
    public void serverCheckAction() {
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        System.out.println("Creating kieBase 创建知识管理基础");
//        KieBase kieBase = kContainer.getKieBase();
        KieBase kieBase = kContainer.getKieBase("server_config_check");
        System.out.println("这里应当有规则");
        for (KiePackage kp : kieBase.getKiePackages()) {
            for (Rule rule : kp.getRules()) {
                System.out.println(kp.getRules().toArray() + " KiePackage " + kp.getName() + " rule " + rule.getName());
            }
        }
        System.out.println("创建知识管理会话 Creating kieSession");
        KieSession session = kieBase.newKieSession();
//        log.info("Now running data");
        /**
         * 这里的值要结合rule.drl的内容来修改，以保证达到预期的结果
         */
        Server s1 = new Server("中科方德 ", 1, 102, 2048);
        session.insert(s1);
        session.fireAllRules();

        Server s2 = new Server("兆芯服务器 ", 8, 4096, 8192);
        session.insert(s2);
        session.fireAllRules();
    }
}