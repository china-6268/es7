package com.hzwtech.cqwjs.jena;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/24
 * @since v1.0
 */
public abstract class CheeseBase extends JenaBase{
    public static final String CHEESE_SCHEMA = "http://data.kasabi.com/dataset/cheese/schema/";
    public static final String CHEESE_DATA = "http://data.kasabi.com/dataset/cheese/";
    public static final String CHEESE_SCHEMA_FILE = ONTOLOGIES_DIR + "cheese.ttl";
    public static final String CHEESE_DATA_FILE = DATA_DIR + "cheeses-0.1.ttl";
}
