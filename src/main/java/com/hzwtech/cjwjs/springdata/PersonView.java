package com.hzwtech.cjwjs.springdata;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/1
 * @since v1.0
 */
public interface PersonView {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}