package com.quan.myblog.utils;

/**
 * @ClassName: Response
 * @Description: 统一的返回信息封装类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 14:01
 */
public class Response<T> {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private String code;
    private String msg;
    private T data;

    public Response() {
    }

    public Response(String code) {
        this.code = code;
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(String code, T data) {
        this.code = code;
        this.data = data;
    }

    // 静态方法
    public static Response success() {
        return new Response(SUCCESS);
    }

    public static Response success(String msg) {
        return new Response(SUCCESS, msg);
    }

    public static Response success(Object data) {
        return new Response(SUCCESS, data);
    }

    public static Response fail() {
        return new Response(FAIL);
    }

    public static Response fail(String msg) {
        return new Response(FAIL, msg);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
