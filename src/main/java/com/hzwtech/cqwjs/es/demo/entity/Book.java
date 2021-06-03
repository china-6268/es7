package com.hzwtech.cqwjs.es.demo.entity;

import lombok.Data;

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

    public Book() {
    }

    public Book(Integer id, Integer userId, String name, Integer price) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name +
                ", price='" + price +
                '\'' +
                '}';
    }
}
