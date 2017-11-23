package com.fcu.gtml.edx.process;

import javax.annotation.Resource;

import org.junit.Test;

import com.fcu.gtml.edx.SupportSpringTest;

public class CourseInfomationTaskTest extends SupportSpringTest {
    @Resource
    private CourseInfomationTask task;

    @Test
    public void test() {
        task.runTask();
    }
}
