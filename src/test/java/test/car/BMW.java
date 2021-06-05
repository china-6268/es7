package test.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
//@Service
@Configuration
@Component
public class BMW implements Car {
    @Lazy
    @Bean("bmwcar")
    @Override
    public String carName() {
        return "BMW car";
    }
}
