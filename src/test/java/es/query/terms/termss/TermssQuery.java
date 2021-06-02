package es.query.terms.termss;

import es.connection.ESUtil;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.junit.Test;

import java.net.UnknownHostException;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/28
 * @since v1.0
 */
public class TermssQuery {
    @Test

    public void termss() throws UnknownHostException, UnknownHostException {
        TransportClient client = ESUtil.getTransportClient();


        AggregationBuilder agg = AggregationBuilders.terms("terms").field("age");
        SearchResponse response = client.prepareSearch("lib3").addAggregation(agg).execute().actionGet();
        Terms terms = response.getAggregations().get("terms");
        for (Terms.Bucket entry : terms.getBuckets()) {
            System.out.println(entry.getKey() + ":" + entry.getDocCount());
        }
    }
}
