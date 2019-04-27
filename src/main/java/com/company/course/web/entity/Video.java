package com.company.course.web.entity;

public class Video {
    private Integer id;
    private String name;
    private Integer enable;
    private Integer pageId;
    private Integer lessonId;

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLesson_id(Integer lessonId) {
        this.lessonId = lessonId;
    }

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

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPage_id(Integer pageId) {
        this.pageId = pageId;
    }
}
