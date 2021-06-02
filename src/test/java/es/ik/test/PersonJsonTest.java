package es.ik.test;

import com.alibaba.fastjson.JSON;
import es.ik.PersonTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/31
 * @since v1.0
 */
@Slf4j
public class PersonJsonTest {
    private List<PersonTest> listOfPersons = new ArrayList<PersonTest>();

    @Before
    public void setUp() {
        listOfPersons.add(new PersonTest(15, "John Doe", new Date()));
        listOfPersons.add(new PersonTest(20, "Janette Doe", new Date()));
    }

    @Test
    public void whenJavathanConvertToJsonCorrect() {
        String jsonOutput = JSON.toJSONString(listOfPersons);
        System.err.println(jsonOutput);
        log.info(jsonOutput);
    }
}
