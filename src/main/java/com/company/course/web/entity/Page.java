package com.company.course.web.entity;

public class Page {
    private Integer id;
    private String name;
    private Integer type;
    private String uri;
    private Integer enable;
    private Integer lessionId;
    private String voiceOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getLessionId() {
        return lessionId;
    }

    public void setLessionId(Integer lessionId) {
        this.lessionId = lessionId;
    }

    public String getVoiceOrder() {
        return voiceOrder;
    }

    public void setVoiceOrder(String voiceOrder) {
        this.voiceOrder = voiceOrder;
    }
}
