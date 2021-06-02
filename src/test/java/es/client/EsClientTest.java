package es.client;

import com.hzwtech.cjwjs.es.client.EsClientImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
@Configurable
public class EsClientTest {
    @Autowired
    private EsClientImpl esClient;

    @Test
    public void aa() {
        EsClientImpl esClient = new EsClientImpl();
        esClient.getRestHighLevelClient();
    }
}
