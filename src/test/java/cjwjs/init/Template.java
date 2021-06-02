package cjwjs.init;//package cjwjs.init;
//
//import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
//import org.elasticsearch.client.transport.TransportClient;
//
///**
// * @author Jasper Liuzengyu 刘增玉
// * @version v1.0.0
// * @description
// * @date 2021/5/27
// * @since v1.0
// */
//public class Template {
//    /**
//     * 判断索引是否存在
//     * @param client
//     * @param indexName
//     * @return
//     */
//    public boolean existIndex(TransportClient client, String indexName){
//        boolean existIndex = false;
//        try {
//            existIndex = client.admin().indices().exists(new IndicesExistsRequest().indices(new String[]{indexName}))
//                    .actionGet().isExists();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return existIndex;
//    }
//    /**
//     * 创建并初始化索引
//     *@param clazz    需要创建索引的实体类
//     * @param indexName    需要创建的索引名称
//     */
//    @SuppressWarnings("rawtypes")
//    public void initIndex(TransportClient client, String indexName, Class clazz){
////        try {
////            if(existIndex(client,indexName)){
////                return; //如果该索引存在，则不创建
////            }
////            CreateIndexRequestBuilder cirBuilder = client.admin().indices().prepareCreate(indexName);
//////            XContentBuilder mapping = XmlContentUtil.getXContentBuilderMapping(clazz);
//////            cirBuilder.addMapping("doc",mapping);
//////            cirBuilder.execute().actionGet();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
//
//}
