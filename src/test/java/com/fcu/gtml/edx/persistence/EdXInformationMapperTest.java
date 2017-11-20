package com.fcu.gtml.edx.persistence;


import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fcu.gtml.edx.SupportSpringTest;
import com.fcu.gtml.edx.domain.CourseOverview;

public class EdXInformationMapperTest extends SupportSpringTest {
    private static final Logger L = LogManager.getLogger();
    @Resource private EdXInformationMapper mapper;

    @Test
    public void listVideoCodes() {
        L.info("EdXInformationMapper:{}", mapper);
        String courseId = "FCUx/2015004/201509";
        String eventType = "load_video";
        List<String> lists = mapper.listVideoCodes(courseId, eventType);
        L.info("lists:{}", lists.size());
        for (String videoCode : lists) {
            L.info("videoCode:{}", videoCode);
        }
    }

    @Test
    public void listCourseOverview() {
        List<CourseOverview> list = mapper.listCourseOverview();
        for (CourseOverview courseOverview : list) {
            L.info("courseOverview:{}", courseOverview);
        }
    }
}
