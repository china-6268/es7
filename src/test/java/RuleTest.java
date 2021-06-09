import com.hzwtech.cqwjs.drools.example.model.Server;
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

public class RuleTest {
//    static final Logger LOG = LoggerFactory.getLogger(RuleTest.class);

    @Test
    public void test() {
        KieServices kieServices = KieServices.Factory.get();

        KieContainer kContainer = kieServices.getKieClasspathContainer();

//        LOG.info("Creating kieBase");
        KieBase kieBase = kContainer.getKieBase();

//        LOG.info("There should be rules: ");
        for ( KiePackage kp : kieBase.getKiePackages() ) {
            for (Rule rule : kp.getRules()) {
                System.err.println("kp " + kp + " rule " + rule.getName());
//                LOG.info("kp " + kp + " rule " + rule.getName());
            }
        }

//        LOG.info("Creating kieSession");
        KieSession session = kieBase.newKieSession();

//        LOG.info("Now running data");

        Server s1 = new Server("rhel7",2,102,2048);
        session.insert(s1);
        session.fireAllRules();
//        assertTrue(s1.isValid());

        Server s2 = new Server("rhel8",2,204,409);
        session.insert(s2);
        session.fireAllRules();
//        assertTrue(s2.isValid());

    }
}