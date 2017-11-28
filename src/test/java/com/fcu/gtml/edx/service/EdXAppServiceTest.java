package com.fcu.gtml.edx.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fcu.gtml.edx.SupportSpringTest;

public class EdXAppServiceTest extends SupportSpringTest {
    private static final Logger L = LogManager.getLogger();
    
    @Resource(name = "mongoTemplate") private MongoOperations mongoOperation;

    @Test
    public void test() {
        L.info("mongoOperation:{}", mongoOperation);
//        Criteria syncCriteria = new Criteria();
//        Query query = Query.query(syncCriteria).limit(500);
//        List<String> list = mongoOperation.find(query, String.class);
//        L.info("list:{}", list.get(0));
//        query.with(new Sort(Sort.Direction.ASC, "_id"));
//        mongoOperation.getCollection("modulestore");
    }
}
