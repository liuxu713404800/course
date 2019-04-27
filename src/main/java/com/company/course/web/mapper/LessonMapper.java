package com.company.course.web.mapper;

import com.company.course.web.entity.Lesson;

import java.util.List;

public interface LessonMapper {

    public List findList();

    public Lesson findById(Integer id);
}
