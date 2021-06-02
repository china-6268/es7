package es.index;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.client.InitDemo;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/27
 * @since v1.0
 */
public class CreateIndexDemo {
    RestHighLevelClient client = InitDemo.getClient();
    private Client transportClient;

    //    @Test
//    public void createDocumentByManually(){
//        String json = "{" +
//                "\"user\":\"kimchy\"," +
//                "\"postDate\":\"2013-01-30\"," +
//                "\"message\":\"trying out Elasticsearch\"" +
//                "}";
//        //IndexRequestBuilder prepareIndex(String index, String type)
//        final IndexResponse response  = this.transportClient.prepareIndex("twitter", "tweet")
//                .setSource(json, XContentType.JSON).get();
//        //获取索引
//        final String _index = response.getIndex();
//        //获取类型
//        final String _type = response.getType();
//        // 文档ID
//        String _id = response.getId();
//        // 版本
//        long _version = response.getVersion();
//        // 返回的操作状态
//        RestStatus status = response.status();
//        System.out.println("索引名称:"+_index+" "+"类型 :" +  _type + " 文档ID："+_id+" 版本 ："+_version+" 返回的操作状态："+status);
//
//    }
//    public static String UpSertDocInEs(){
//        IndexRequest request = new IndexRequest("users");
//        request.id(user.getUserId());
//        request.source(new ObjectMapper().writeValueAsString(user), XContentType.JSON);
//        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
//        System.out.println("response id: "+indexResponse.getId());
//        return indexResponse.getResult().name();
//    }
    public static void main(String[] args) throws UnknownHostException, JsonProcessingException {
        Settings settings = Settings.builder()
                .put("cluster.name", "myClusterName").build();
//        TransportClient client = new PreBuiltTransportClient(settings);
        //on startup
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getLocalHost(), 9200));
        //继续添加其他地址
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user", "kimchy");
        json.put("postDate", new Date());
        json.put("message", "trying out Elasticsearch");
// index--twitter  type--_doc  id--1
        IndexResponse indexResponse = client.prepareIndex("twitter", "_doc", "1").setSource(json, XContentType.JSON).get();
        // Index name
        String _index = indexResponse.getIndex();
        // Type name
        String _type = indexResponse.getType();
        // Document ID (generated or not)
        String _id = indexResponse.getId();
        // Version (if it's the first time you index this document, you will get: 1)
        long _version = indexResponse.getVersion();
        // status has stored current instance statement.
        RestStatus status = indexResponse.status();
        //on shutdown
        client.close();
    }

    public static void main1(String[] args) throws IOException {
        //这里和RESTful风格不同
        try (RestHighLevelClient client = InitDemo.getClient();) {
//        // 1、创建 创建索引 request
            CreateIndexRequest request = new CreateIndexRequest("mess12345");
//        // 2、设置索引的settings
            request.settings(Settings.builder().put("index.number_of_shards", 3) // 分片数
                    .put("index.number_of_replicas", 2) // 副本数
                    .put("analysis.analyzer.default.tokenizer", "ik_smart") // 默认分词器
            );
            // 3、设置索引的mappings
//            request.mapping("{\n" + "  \"properties\": {\n" + " \"message\": {\n" + " \"type\": \"text\"\n" + " }\n" + "  }\n" + "}", XContentType.JSON);

            Map<String, Object> message = new HashMap<>();
            message.put("type", "text");
            Map<String, Object> properties = new HashMap<>();
            properties.put("userId", message);
            properties.put("name", message);
            Map<String, Object> mapping = new HashMap<>();
            mapping.put("properties", properties);

            request.mapping(mapping);
            //        // 4、 设置索引的别名
            request.alias(new Alias("twitter_alias1").filter(QueryBuilders.termQuery("user1", "kimchy")));
//整体参数
            request.source("{\n" + " \"settings\" : {\n" + " \"number_of_shards\" : 1,\n" + " \"number_of_replicas\" : 0\n" + " },\n" + " \"mappings\" : {\n" + " \"properties\" : {\n" + " \"message\" : { \"type\" : \"text\" }\n" + " }\n" + " },\n" + " \"aliases\" : {\n" + " \"twitter_alias\" : {}\n" + " }\n" + "}", XContentType.JSON);
            request.setTimeout(TimeValue.timeValueMinutes(2));
// 5、 发送请求 这里和RESTful风格不同
            CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
//        // 6、处理响应
            boolean acknowledged = createIndexResponse.isAcknowledged();
            boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();
            System.out.println("acknowledged = " + acknowledged);
            System.out.println("shardsAcknowledged = " + shardsAcknowledged);
            System.out.println("response id: " + createIndexResponse.index());
//upset a doc in es


//            CreateIndexRequest request = new CreateIndexRequest("users");
//            request.settings(Settings.builder()
//                    .put("index.number_of_shards", 1)
//                    .put("index.number_of_replicas", 2)
//            );

//
//        // listener方式发送请求
//            /*ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {
//                @Override
//                public void onResponse(
//                        CreateIndexResponse createIndexResponse) {
//                    // 6、处理响应
//                    boolean acknowledged = createIndexResponse.isAcknowledged();
//                    boolean shardsAcknowledged = createIndexResponse
//                            .isShardsAcknowledged();
//                    System.out.println("acknowledged = " + acknowledged);
//                    System.out.println(
//                            "shardsAcknowledged = " + shardsAcknowledged);
//                }
//
//                @Override
//                public void onFailure(Exception e) {
//                    System.out.println("创建索引异常：" + e.getMessage());
//                }
//            };
//            client.admin().indices().create(request, listener);
//            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createDocumentByMap() {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user", "kimchy");
        json.put("postDate", new Date());
        json.put("message", "trying out Elasticsearch");
        //this.transportClient.prepareIndex 可以传入id
        final IndexResponse response = this.transportClient.prepareIndex("twitter", "tweet")
                .setSource(json, XContentType.JSON).get();
        //获取索引
        final String _index = response.getIndex();
        //获取类型
        final String _type = response.getType();
        // 文档ID
        String _id = response.getId();
        // 版本
        long _version = response.getVersion();
        // 返回的操作状态
        RestStatus status = response.status();
        System.out.println("索引名称:" + _index + " " + "类型 :" + _type + " 文档ID：" + _id + " 版本 ：" + _version + " 返回的操作状态：" + status);
    }
}