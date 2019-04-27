package com.company.course.web.service;

import com.company.course.web.entity.Lesson;
import com.company.course.web.mapper.LessonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LessonService {
    @Resource
    private LessonMapper lessonMapper = null;

    public List<Lesson> findList() {
        return lessonMapper.findList();
    }

    public Lesson findById(Integer id) {
        return lessonMapper.findById(id);
    }
}
