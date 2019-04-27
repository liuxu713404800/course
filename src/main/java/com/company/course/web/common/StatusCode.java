package com.company.course.web.common;

public enum StatusCode {
    SUCCESS(1, "success"),

    // 用户名和密码相关
    NAME_EMPTY(100001, "用户名不能为空"),
    PASSWORD_EMPTY(100002, "密码不能为空"),
    USER_NOT_EXIST(100003, "用户不存在"),
    PASSWORD_UNCORRECT(100004, "密码错误"),
    LOGIN_EXPIRED(100005, "登录过期"),


    // 课程相关
    LESSON_UNLOCKED(200001, "课程未解锁"),
    FAILED(0, "failed");

    final int code;
    final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() { return code; }

    public String getMsg() { return msg; }
}
