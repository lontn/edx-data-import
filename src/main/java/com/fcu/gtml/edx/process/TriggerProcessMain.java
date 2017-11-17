package com.fcu.gtml.edx.process;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TriggerProcessMain {
    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:/com/fcu/gtml/edx/spring-config.xml", "classpath:/com/fcu/gtml/edx/spring-datasource.xml", "classpath:/com/fcu/gtml/edx/spring-mongo.xml", "classpath:spring-task.xml");
    }
}
