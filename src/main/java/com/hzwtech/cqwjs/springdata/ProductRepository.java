package com.hzwtech.cqwjs.springdata;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.stereotype.Repository;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/1
 * @since v1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String productName);
}
