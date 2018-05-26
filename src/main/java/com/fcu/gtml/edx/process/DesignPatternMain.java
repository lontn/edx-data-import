package com.fcu.gtml.edx.process;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DesignPatternMain {
    private static final Logger L = LogManager.getLogger();
    static DesignPatternAdapter adapter;

    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:/com/fcu/gtml/edx/spring-config.xml",
                "classpath:/com/fcu/gtml/edx/spring-datasource.xml");
        adapter = ac.getBean(DesignPatternAdapter.class);
        adapter.start();
    }
}
