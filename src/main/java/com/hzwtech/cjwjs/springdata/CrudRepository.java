package com.hzwtech.cjwjs.springdata;

import java.io.Serializable;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description provides CRUD functions
 * @date 2021/6/1
 * @since v1.0
 */
public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {

    <S extends T> S save(S entity);

    T findOne(ID primaryKey);

    Iterable<T> findAll();

    Long count();

    void delete(T entity);

    boolean exists(ID primaryKey);
}
