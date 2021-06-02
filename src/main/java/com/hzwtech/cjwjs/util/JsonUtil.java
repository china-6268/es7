package com.hzwtech.cjwjs.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String objectToString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T stringToObject(String json, Class<T> object) throws IOException {
        return objectMapper.readValue(json, object);
    }
}
