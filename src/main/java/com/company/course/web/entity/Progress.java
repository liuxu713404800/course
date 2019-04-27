package com.company.course.web.entity;

public class Progress {
    private Integer id;
    private Integer uid;
    private Integer lessonId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    // 这里完成映射
    public void setLesson_id(Integer lessonId) {
        this.lessonId = lessonId;
    }
}
