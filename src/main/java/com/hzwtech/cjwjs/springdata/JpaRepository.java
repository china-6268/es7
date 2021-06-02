package com.hzwtech.cjwjs.springdata;

import org.apache.lucene.search.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description provides JPA related methods such as flushing the persistence context and delete records in a batch
 * @date 2021/6/1
 * @since v1.0
 */
public interface JpaRepository<T, ID extends Serializable> extends
        PagingAndSortingRepository<T, ID> {
    @Override
    List<T> findAll();

    @Override
    List<T> findAll(Sort sort);

    List<T> save(Iterable<? extends T> entities);

    void flush();

    T saveAndFlush(T entity);

    void deleteInBatch(Iterable<T> entities);
}
