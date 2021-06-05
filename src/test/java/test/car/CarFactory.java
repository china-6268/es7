package test.car;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */

public class CarFactory {
//    @Autowired
//    @Qualifier("bmwcar")
//    @Inject
//    private Car car;

//    @Autowired
//    @Qualifier("benz")
//    private Car benz;

//    public String toString() {
//        return car.carName();
//    }

    @Test
    public void toStringBiz(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BMW.class);
        Car car = (Car) context.getBean("bmwcar");
        System.out.println(car.carName());
    }
}
