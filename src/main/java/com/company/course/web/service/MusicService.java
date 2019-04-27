package com.company.course.web.service;

import com.company.course.web.entity.Music;
import com.company.course.web.mapper.MusicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MusicService {
    @Resource
    private MusicMapper musicMapper = null;

    public List<Music> findList(Integer lessonId) {
        return musicMapper.findList(lessonId);
    }

}
