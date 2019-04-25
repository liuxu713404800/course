package com.company.course.web.common;

public class UserException extends RuntimeException {
    private int code;
    private String msg;

    public UserException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public UserException(StatusCode statusCode) {
        super(statusCode.getMsg());
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
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
