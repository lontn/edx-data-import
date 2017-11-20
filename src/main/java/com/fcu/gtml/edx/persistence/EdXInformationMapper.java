package com.fcu.gtml.edx.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fcu.gtml.edx.domain.CourseOverview;

public interface EdXInformationMapper {
    public static final String BY_COURSEID = "courseId";
    public static final String BY_EVENTTYPE = "eventType";

    
    public List<String> listVideoCodes(@Param("courseId") String courseId, @Param("eventType") String eventType);

    public List<CourseOverview> listCourseOverview();
}
