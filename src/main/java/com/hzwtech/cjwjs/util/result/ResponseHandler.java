package com.hzwtech.cjwjs.util.result;

import com.hzwtech.cjwjs.util.JsonUtil;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
@ControllerAdvice(basePackages = "com.hzwtech.cjwjs.util")
public class ResponseHandler implements ResponseBodyAdvice {
    //当返回值为true时功能才生效
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (o instanceof String) {
            return JsonUtil.objectToString(Result.succ(o));
        }
        return Result.succ(o);
    }
}
