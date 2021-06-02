package com.hzwtech.cjwjs.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.hzwtech.cjwjs.biz.domain.BookModel;
import com.hzwtech.cjwjs.biz.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/1
 * @since v1.0
 */
@Slf4j
public class BookServiceImpl implements BookService {
    private static final String INDEX_NAME = "test1";
    private static final String INDEX_TYPE = "_doc";

    @Autowired
    private RestHighLevelClient client;

    @Override
    public BookModel detail(int id) {
        GetRequest getRequest = new GetRequest(INDEX_NAME, INDEX_TYPE, String.valueOf(id));
        try {
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
            if (getResponse.isExists()) {
                String source = getResponse.getSourceAsString();
                BookModel book = JSON.parseObject(source, BookModel.class);
                log.info(book.toString());
                return book;
            }
        } catch (IOException e) {
            log.error("查看失败！原因: {}", e.getMessage(), e);
        }
        return null;
    }
}
