package com.fcu.gtml.edx.service;

import java.util.List;

import com.fcu.gtml.edx.domain.CourseOverview;

public interface EdXInformationService {

    public List<String> listVideoCodes(String courseId, String eventType);

    public List<CourseOverview> listCourseOverview();
}
