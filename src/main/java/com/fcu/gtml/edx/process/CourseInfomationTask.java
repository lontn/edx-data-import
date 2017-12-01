package com.fcu.gtml.edx.process;


import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fcu.gtml.edx.domain.CourseMaterialInfo;
import com.fcu.gtml.edx.domain.CourseOverview;
import com.fcu.gtml.edx.domain.YoutuBe;
import com.fcu.gtml.edx.service.EdXInformationService;
import com.fcu.gtml.edx.service.YoutubeAPIService;
import com.fcu.gtml.edx.task.AbstractTask;

public class CourseInfomationTask extends AbstractTask {
    private static final Logger L = LogManager.getLogger();
    @Resource
    private EdXInformationService edxService;
    @Resource
    private YoutubeAPIService youtubeAPIService;
    private String eventType;

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }


    @Override
    public void runTask() {
        L.info("CourseInfomationTask Start........");
        // 撈出課程資訊
        List<CourseOverview> listCourses = edxService.listCourseOverview();
        for (CourseOverview course : listCourses) {
            String courseId = course.getId();
            L.info("CourseOverview:{}", courseId);
            try {
                //針對課程資訊撈出Video Code
                List<String> listVideoCodes = edxService.listVideoCodes(courseId, eventType);
                L.info("listVideoCodes:{}", listVideoCodes.size());
                // 呼叫Youtube API
                processYoutubeData(listVideoCodes, course);
            } catch (Exception e) {
                L.error("CourseOverview:{}", course);
                L.error("runTask Exception:{}", e);
            }
        }
        L.info("CourseInfomationTask End........");
    }

    private void processYoutubeData(List<String> listVideoCodes, CourseOverview course) {
        for (String code : listVideoCodes) {
            String courseId = course.getId();
            YoutuBe youbuBe = youtubeAPIService.getYoutubeAPI(code);
            //再取新的API
            CourseMaterialInfo newCourseMaterial = new CourseMaterialInfo(course, youbuBe);
            // TODO INSERT ?
//            int count = edxService.countCourseMateria(code, courseId);
            CourseMaterialInfo courseMaterialInfo = edxService.findCourseMateria(code, courseId);
            try {
                if (courseMaterialInfo == null) {
                    // insert & History
                    edxService.insertCourseMaterialInfo(newCourseMaterial);
                } else {
                    // 撈出原本的
                    // update & History
                    edxService.updateCourseMaterialInfo(newCourseMaterial, courseMaterialInfo);
                }
            } catch (Exception e) {
                L.error("videoCode:{}", code);
                L.error("courseMaterialInfo:{}", courseMaterialInfo);
                L.error("newCourseMaterial:{}", newCourseMaterial);
                L.error("processYoutubeData:{}", e);
            }
        }
    }
}
