package com.fcu.gtml.edx.service;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fcu.gtml.edx.SupportSpringTest;
import com.fcu.gtml.edx.domain.YoutuBe;

public class YoutubeAPIServiceTest extends SupportSpringTest {
    private static final Logger L = LogManager.getLogger();
    @Resource
    private YoutubeAPIService service;
    
    @Test
    public void test() {
        YoutuBe youtube = service.getYoutubeAPI("9H2KWHmbGA0");
        L.info("youtube:{}", youtube);
    }
}
