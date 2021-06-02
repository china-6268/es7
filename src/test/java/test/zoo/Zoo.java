package test.zoo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
public class Zoo {
    @Autowired
    private Tiger tiger;

    @Autowired
    private Monkey monkey;

    @Test
    public String toString() {
        return tiger + "\n" + monkey;
    }
//    private Tiger tiger;
//    private Monkey monkey;
//
//    public void setTiger(Tiger tiger)
//    {
//        this.tiger = tiger;
//    }
//
//    public void setMonkey(Monkey monkey)
//    {
//        this.monkey = monkey;
//    }
//
//    public Tiger getTiger()
//    {
//        return tiger;
//    }
//
//    public Monkey getMonkey()
//    {
//        return monkey;
//    }
//
//    public String toString()
//    {
//        return tiger + "\n" + monkey;
//    }
}
