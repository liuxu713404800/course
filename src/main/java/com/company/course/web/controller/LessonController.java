package com.company.course.web.controller;

import com.company.course.web.common.ApiError;
import com.company.course.web.common.ApiResult;
import com.company.course.web.common.StatusCode;
import com.company.course.web.entity.*;
import com.company.course.web.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class LessonController extends BaseController{
    @Value("${base-file-folder}")
    public String baseFilePath;

    @Resource
    private PageService pageService = null;
    @Resource
    private TokenService tokenService = null;
    @Resource
    private ProgressService progressService = null;
    @Resource
    private LessonService lessonService = null;
    @Resource
    private VideoService videoService = null;
    @Resource
    private VoiceService voiceService = null;


    @RequestMapping("/media/list")
    ApiResult<Map> findList(HttpServletRequest request) {
        // 校验token合法
        String tokenParam = request.getParameter("token");
        Token token = tokenService.getByToken(tokenParam);
        if (token == null || token.getEffective() != 1) {
            return new ApiError(StatusCode.LOGIN_EXPIRED);
        }

        Progress progress = progressService.findByUid(token.getUid());
        Integer preLessonId = 0;
        if (progress != null) {
            preLessonId = progress.getLessonId();
        }

        List lessonList = lessonService.findList();
        ArrayList ret = new ArrayList<TreeMap>();
        for (Object lesson : lessonList) {
            Lesson current = (Lesson) lesson;
            Map map = new TreeMap();
            map.put("id", current.getId());
            map.put("name", current.getName());
            map.put("image", current.getImage());
            map.put("status", preLessonId >= current.getId() ? 1 : 2);
            ret.add(map);
        }

        Map res = new HashMap();
        res.put("list", ret);
        return new ApiResult<Map>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), res);
    }

    @RequestMapping("/media/detail")
    ApiResult<Map> getDetail(HttpServletRequest request) {
        // 校验token合法
        String tokenParam = request.getParameter("token");
        Token token = tokenService.getByToken(tokenParam);
        if (token == null || token.getEffective() != 1) {
            return new ApiError(StatusCode.LOGIN_EXPIRED);
        }
        String lessonId = request.getParameter("lesson_id");
        Progress progress = progressService.findByUid(token.getUid());
        Integer preLessonId = 0;
        if (progress != null) {
            preLessonId = progress.getLessonId();
        }

        Integer currentLesson = Integer.parseInt(lessonId);
        if (currentLesson > preLessonId) {
            return new ApiError(StatusCode.LESSON_UNLOCKED);
        }
        Lesson lesson = lessonService.findById(currentLesson);
        String basePagePath = "/course-resouces/lesson-" + lessonId + "/pages/";
        String baseVoicePath = "/course-resouces/lesson-" + lessonId + "/voices/";
        String baseVideoPath = "/course-resouces/lesson-" + lessonId + "/videos/";

        List pageList = pageService.findList(currentLesson);
        List voiceList = voiceService.findList(currentLesson);
        List videoList = videoService.findList(currentLesson);

        ArrayList ret = new ArrayList<TreeMap>();
        for (Object page : pageList) {
            Page currentPage = (Page) page;
            Map pageMap = new TreeMap();
            Integer type = 1;
            String url = basePagePath + currentPage.getName();
            for (Object video : videoList) {
                Video currentVideo = (Video) video;
                if (currentVideo.getPageId() == currentPage.getId()) {
                    type = 2;
                    url = baseVideoPath + currentVideo.getName();
                }
            }
            pageMap.put("type", type);
            pageMap.put("name", lesson.getName());
            pageMap.put("url", url);

            List<String> voices = new ArrayList<String>();
            for (Object voice : voiceList) {
                Voice currentVoice = (Voice) voice;
                if (currentVoice.getPageId() == currentPage.getId()) {
                    voices.add(baseVoicePath + currentVoice.getName());
                }
            }
            pageMap.put("audio", voices);
            ret.add(pageMap);
        }

        Map res = new HashMap();
        res.put("list", ret);
        return new ApiResult<Map>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), res);
    }
}
