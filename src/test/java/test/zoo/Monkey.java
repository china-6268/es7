package test.zoo;

import org.springframework.stereotype.Service;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
@Service
public class Monkey {
    private String monkeyName = "MonkeyKing";

    public String toString()
    {
        return "MonkeyName:" + monkeyName;
    }
}
