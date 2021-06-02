package es.ik;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/31
 * @since v1.0
 */
//@Slf4j
@Data
public class PersonTest {
    @JSONField(name = "AGE")
    private int age;

    @JSONField(name = "FULL NAME")
    private String fullName;

    @JSONField(name = "DATE OF BIRTH")
    private Date dateOfBirth;

    public PersonTest(int age, String fullName, Date dateOfBirth) {
        super();
        this.age = age;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }
}