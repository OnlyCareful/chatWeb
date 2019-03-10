package com.chatweb.only.bean;

/**
 * 自定义异常信息
 * @author InnerConce
 * @date 2019/03/08
 */
public enum ResultCode {
    /**
     * 请求成功
     */
    SUCCEED(200,"请求成功"),
    /**
     * 自定义异常
     */
    CUSTOM(302,"自定义异常"),
    /**
     * 服务器内部错误
     */
    FAILURE(500,"服务器内部错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
