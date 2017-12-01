package com.fcu.gtml.edx.service;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fcu.gtml.edx.SupportSpringTest;
import com.fcu.gtml.edx.domain.CourseMaterialInfo;

public class EdXInformationServiceTest extends SupportSpringTest {
    private static final Logger L = LogManager.getLogger();
    @Resource private EdXInformationService service;

    @Test
    public void findCourseMateria() {
        CourseMaterialInfo course = service.findCourseMateria("9H2KWHmbGA0", "FCUx/2015004/201509");
        L.info("course:{}", course);
    }
}
