package test.car;

import org.springframework.stereotype.Service;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
@Service
public class BMW implements Car {

    @Override
    public String carName() {
        return "BMW car";
    }
}
