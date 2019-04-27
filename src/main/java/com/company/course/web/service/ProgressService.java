package com.company.course.web.service;

import com.company.course.web.entity.Progress;
import com.company.course.web.mapper.ProgressMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProgressService {

    @Resource
    private ProgressMapper progressMapper = null;

    public Progress findByUid(Integer uid) {
        return progressMapper.findByUid(uid);
    }
}
