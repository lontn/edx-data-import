package com.fcu.gtml.edx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fcu.gtml.edx.domain.CourseMaterialHistory;
import com.fcu.gtml.edx.domain.CourseMaterialInfo;
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

    @Override
    public int countCourseMateria(String videoCode, String courseId) {
        return edxMapper.countCourseMateria(videoCode, courseId);
    }

    @Override
    public CourseMaterialInfo findCourseMateria(String videoCode, String courseId) {
        return edxMapper.findCourseMateria(videoCode, courseId);
    }

    @Override
    public void insertCourseMaterialInfo(CourseMaterialInfo courseMaterialInfo) {
        edxMapper.insertCourseMaterialInfo(courseMaterialInfo);
        CourseMaterialHistory history = new CourseMaterialHistory(courseMaterialInfo);
        edxMapper.insertCourseMaterialHistory(history);
    }

    @Override
    public void updateCourseMaterialInfo(CourseMaterialInfo newCourseMaterial, CourseMaterialInfo courseMaterialInfo) {
        edxMapper.updateCourseMaterialInfo(newCourseMaterial);
        CourseMaterialHistory history = new CourseMaterialHistory(courseMaterialInfo);
        edxMapper.insertCourseMaterialHistory(history);
    }



}
