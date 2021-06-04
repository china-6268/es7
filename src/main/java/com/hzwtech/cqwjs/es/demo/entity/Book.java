package com.hzwtech.cqwjs.es.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
@Data
public class Book {
    private Integer id;
    private Integer userId;
    private String name;
    private Integer price;
    private Date buyDate;

    public Book() {
    }

    public Book(Integer id, Integer userId, String name, Integer price, Date buyDate) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.price = price;
        this.buyDate = buyDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name +
                ", price='" + price +
                ", buyDate='" + buyDate +
                '\'' +
                '}';
    }
}
