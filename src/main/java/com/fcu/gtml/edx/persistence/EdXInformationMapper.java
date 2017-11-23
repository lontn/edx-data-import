package com.fcu.gtml.edx.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fcu.gtml.edx.domain.CourseMaterialInfo;
import com.fcu.gtml.edx.domain.CourseOverview;

public interface EdXInformationMapper {
    public static final String BY_COURSEID = "courseId";
    public static final String BY_EVENTTYPE = "eventType";

    /**
     * 取得課程的每個Youtube Code
     * @param courseId
     * @param eventType
     * @return
     */
    public List<String> listVideoCodes(@Param("courseId") String courseId, @Param("eventType") String eventType);

    /**
     * 取得課程資訊
     * @return
     */
    public List<CourseOverview> listCourseOverview();

    public int countCourseMateria(@Param("videoCode") String videoCode);

    public void insertCourseMaterialInfo(CourseMaterialInfo courseMaterialInfo);
}
