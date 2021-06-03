package com.hzwtech.cqwjs.springdata;

import org.apache.lucene.search.Sort;

import java.io.Serializable;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description provides methods to do pagination and sort records
 * @date 2021/6/1
 * @since v1.0
 */
public interface PagingAndSortingRepository<T, ID extends Serializable>
        extends CrudRepository<T, ID> {

    Iterable<T> findAll(Sort sort);

//    Page<T> findAll(Pageable pageable);
}
