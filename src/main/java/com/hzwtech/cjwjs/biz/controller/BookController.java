package com.hzwtech.cjwjs.biz.controller;

import com.hzwtech.cjwjs.biz.service.BookService;
import net.sf.ehcache.search.impl.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/1
 * @since v1.0
 */
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 查看文档
     */
    @GetMapping("/detail")
    public BaseResult detail(Integer id) {
//        if (null == id) {
//            return BaseResult.error("ID不能为空");
//        }
//        BookModel book = bookService.detail(id);
//        return BaseResult.ok(book);
        return null;
    }
}