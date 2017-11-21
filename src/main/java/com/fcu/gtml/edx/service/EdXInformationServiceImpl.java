package com.fcu.gtml.edx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fcu.gtml.edx.domain.CourseOverview;
import com.fcu.gtml.edx.persistence.EdXInformationMapper;

@Service
public class EdXInformationServiceImpl implements EdXInformationService {
    @Resource
    private EdXInformationMapper edxMapper;

    @Override
    public List<String> listVideoCodes(String courseId, String eventType) {
        List<String> listVideos = edxMapper.listVideoCodes(courseId, eventType);
        return listVideos;
    }

    @Override
    public List<CourseOverview> listCourseOverview() {
        List<CourseOverview> listCourses = edxMapper.listCourseOverview();
        return listCourses;
    }

}
