package com.fcu.gtml.edx.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fcu.gtml.edx.SupportSpringTest;

public class ConfigurationTest extends SupportSpringTest {
    private static final Logger L = LogManager.getLogger();

    @Test
    public void prop() {
        String part = Configuration.YoutubeAPI.getPart();
        String key = Configuration.YoutubeAPI.getPrivateKey();
        L.info("part:{}, key:{}", part, key);
    }
}
