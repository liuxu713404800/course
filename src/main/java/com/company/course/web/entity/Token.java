package com.company.course.web.entity;

public class Token {
    private Integer id;
    private Integer created;
    private Integer updated;
    private Integer uid;
    private String token;
    private Integer effective;

    public Token() { }

    public Token(Integer created, Integer updated, Integer uid, String token, Integer effective) {
        this.created = created;
        this.updated = updated;
        this.uid = uid;
        this.token = token;
        this.effective = effective;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getEffective() {
        return effective;
    }

    public void setEffective(Integer effective) {
        this.effective = effective;
    }
}
