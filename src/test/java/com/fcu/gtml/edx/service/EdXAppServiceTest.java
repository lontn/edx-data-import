package com.fcu.gtml.edx.service;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;

import com.fcu.gtml.edx.SupportSpringTest;

public class EdXAppServiceTest extends SupportSpringTest {
    private static final Logger L = LogManager.getLogger();
    
    @Resource(name = "mongoTemplate") private MongoOperations mongoOperation;

    @Test
    public void test() {
        L.info("mongoOperation:{}", mongoOperation);
    }
}
