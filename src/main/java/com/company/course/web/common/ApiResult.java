package com.company.course.web.common;

public class ApiResult<T> {
    private int code;
    private String msg;
    private T data;

    // 使用频率最高，直接传入data即可
    public ApiResult(T data) {
        this.code = StatusCode.SUCCESS.getCode();
        this.msg = StatusCode.SUCCESS.getMsg();
        this.data = data;
    }

    // 选择模板中的状态码和信息来，完成封装
    public ApiResult(StatusCode statusCode, T data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    // 完全自定义类型、消息和数据
    public ApiResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
