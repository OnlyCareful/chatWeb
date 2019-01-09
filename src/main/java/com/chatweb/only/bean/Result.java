package com.chatweb.only.bean;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public Result(ResultCode resultCode, String msg){
        this.code = resultCode.getCode();
        this.msg = msg;
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public Result(ResultCode resultCode, String msg, T data){
        this.code = resultCode.getCode();
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /*@Override
    public String toString() {
        return JSON.toJSONString(this);
    }*/
}
