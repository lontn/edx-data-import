package com.fcu.gtml.edx.process;


import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fcu.gtml.edx.domain.CourseOverview;
import com.fcu.gtml.edx.service.EdXInformationService;
import com.fcu.gtml.edx.task.AbstractTask;

public class CourseInfomationTask extends AbstractTask {
    private static final Logger L = LogManager.getLogger();
    @Resource
    private EdXInformationService edxService;
    private String eventType;

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }


    @Override
    public void runTask() {
        // 撈出課程資訊
        List<CourseOverview> listCourses = edxService.listCourseOverview();
        for (CourseOverview course : listCourses) {
            String courseId = course.getId();
            List<String> listVideoCodes = edxService.listVideoCodes(courseId, eventType);
            // TODO 呼叫Youtube API
        }
    }

}
