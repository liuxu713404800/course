package com.company.course.web.service;

import com.company.course.web.entity.Page;
import com.company.course.web.mapper.PageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PageService {
    @Resource
    private PageMapper pageMapper = null;

    public List<Page> findList(Integer lessonId) {
        return pageMapper.findList(lessonId);
    }
}
