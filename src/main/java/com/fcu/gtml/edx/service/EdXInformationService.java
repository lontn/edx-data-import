package com.fcu.gtml.edx.service;

import java.util.List;

import com.fcu.gtml.edx.domain.CourseMaterialInfo;
import com.fcu.gtml.edx.domain.CourseOverview;

public interface EdXInformationService {

    /**
     * 取得課程的每個Youtube Code
     * @param courseId
     * @param eventType
     * @return
     */
    public List<String> listVideoCodes(String courseId, String eventType);

    /**
     * 取得課程資訊
     * @return
     */
    public List<CourseOverview> listCourseOverview();

    public int countCourseMateria(String videoCode, String courseId);

    public void insertCourseMaterialInfo(CourseMaterialInfo courseMaterialInfo);
}
