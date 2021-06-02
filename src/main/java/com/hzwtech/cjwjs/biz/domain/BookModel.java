package com.hzwtech.cjwjs.biz.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/1
 * @since v1.0
 */
@Data
public class BookModel implements Serializable {
    //  图书ID
    private Integer id;

    //  图书名称
    private String name;

    //  作者
    private String author;

    //  图书分类
    private Integer category;

    //  图书价格
    private Double price;

    //  上架理由
    private String sellReason;

    //  上架时间
    private String sellTime;

    //  状态（1：可售，0：不可售）
    private Integer status;
}
