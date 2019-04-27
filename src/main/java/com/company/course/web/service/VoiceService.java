package com.company.course.web.service;

import com.company.course.web.entity.Voice;
import com.company.course.web.mapper.VoiceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VoiceService {

    @Resource
    private VoiceMapper voiceMapper = null;

    public List<Voice> findList(Integer lessonId) {
        return voiceMapper.findList(lessonId);
    }
}
