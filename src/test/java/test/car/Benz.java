package test.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
@Configuration
public class Benz implements Car{
    @Bean
    @Override
    public String carName() {
        return "Benz car";
    }
}
