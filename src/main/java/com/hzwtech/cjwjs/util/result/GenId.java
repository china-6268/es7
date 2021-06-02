package com.hzwtech.cjwjs.util.result;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
public interface GenId<String> {
    String genId(String table, String column);
//    String genId(String table);
}
