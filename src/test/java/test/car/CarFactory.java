package test.car;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
@Service
public class CarFactory {
    @Autowired
    @Qualifier("BMW")
    private Car car;

    public String toString() {
        return car.carName();
    }
}
