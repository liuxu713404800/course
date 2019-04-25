package com.company.course.web.common;

public class ApiError<T> extends ApiResult{
    private int code;
    private String msg;
    private T data;

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

    // 模板中编码和错误
    public ApiError(StatusCode statusCode) {
        super(statusCode.getMsg());
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }

    // 自定义编码和错误
    public ApiError(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

}
