package drools.verity;

import com.hzwtech.cqwjs.drools.example.model.Product;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ProductTest {
    @Test
    public void prouctDisscountTest() {
        try {
            KieServices kieServices = KieServices.Factory.get();
            KieContainer kContainer = kieServices.getKieClasspathContainer();
            System.out.println("Creating kieBase 创建知识管理基础");
            KieBase kieBase = kContainer.getKieBase("product_discount_confirm");
            KieSession kSession = kieBase.newKieSession();
            Product product = new Product();
//            product.setType("gold");
            product.setType("diamond");
            kSession.insert(product);
            kSession.fireAllRules();
            System.err.println("The discount for the jewellery product "
                    + product.getType() + " is " + product.getDiscount());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}