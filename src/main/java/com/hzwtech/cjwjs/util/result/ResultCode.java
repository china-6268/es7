package com.hzwtech.cjwjs.util.result;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
public enum ResultCode {
    SUCCESS(0, "成功"),
    SYSTEM_ERROR(500, "系统错误"),
    PARAM_IS_INVALID(1000, "参数错误"),
    USER_IS_EXISTED(1001, "用户已存在");
    private Integer status;
    private String message;

    ResultCode(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer status() {
        return this.status;
    }

    public String message() {
        return this.message;
    }
}
