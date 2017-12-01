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
import com.fcu.gtml.edx.domain.Modulestore;

public class EdXAppServiceTest extends SupportSpringTest {
    private static final Logger L = LogManager.getLogger();
    
    @Resource(name = "mongoTemplate") private MongoOperations mongoOperation;

    @Test
    public void test() {
        L.info("mongoOperation:{}", mongoOperation);
        Criteria syncCriteria = new Criteria();
        syncCriteria.and("_id.org").is("FCUx");
        syncCriteria.and("_id.course").is("2015004");
        syncCriteria.and("_id.category").is("video");
        Query query = Query.query(syncCriteria);
        List<Modulestore> list = mongoOperation.find(query, Modulestore.class);
        L.info("list:{}", list.size());
        L.info("list:{}", list);
//        query.with(new Sort(Sort.Direction.ASC, "_id"));
//        mongoOperation.getCollection("modulestore");
    }
}
