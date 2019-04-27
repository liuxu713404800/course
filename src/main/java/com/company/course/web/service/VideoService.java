package com.company.course.web.service;

import com.company.course.web.entity.Video;
import com.company.course.web.mapper.VideoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoService {

    @Resource
    private VideoMapper videoMapper = null;

    public List<Video> findList(Integer lessonId) {
        return videoMapper.findList(lessonId);
    }
}
