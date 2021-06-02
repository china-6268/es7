package es.query.get;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.connection.ESUtil;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/27
 * @since v1.0
 */
public class GetInfo {
    public static void main(String[] args) throws UnknownHostException, JsonProcessingException {
        TransportClient transportClient = ESUtil.getTransportClient();
        Settings settings = Settings.builder()
                .put("cluster.name", "myClusterName").build();


        //on startup
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
        //继续添加其他地址

        GetResponse documentFields = client.prepareGet("twitter", "_doc", "1").get();
        System.out.println(documentFields.getIndex());
        System.out.println(documentFields.getType());
        System.out.println(documentFields.getId());
        System.out.println(documentFields.getSourceAsString());
        //on shutdown
        client.close();
    }
}
