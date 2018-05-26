package com.fcu.gtml.edx.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fcu.gtml.edx.SupportSpringTest;

public class CallOutSiteAPIServiceTest extends SupportSpringTest {
    private static final Logger L = LogManager.getLogger();

    private CallOutSiteAPIService service = new CallKeyIdAPIServiceImpl();

    @Test
    public void test() {
        L.info("service:{}", service);
        List<String> lists = service.listKeyIds();
        L.info("AAAA:{}", lists);
    }
}
