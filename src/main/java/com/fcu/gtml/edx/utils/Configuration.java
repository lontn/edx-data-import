package com.fcu.gtml.edx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ResourceUtils;

public class Configuration {
    private static final Logger L = LogManager.getLogger();

    public static class YoutubeAPI {
        private static Properties prop;

        public static synchronized Properties getConfig() {
            if (prop == null) {
                try(InputStream is = ResourceUtils.getURL("classpath:YoutubeAPI.properties").openStream();) {
                    prop = new Properties();
                    prop.load(is);
                } catch (IOException e) {
                    L.error("classpath:YoutubeAPI.properties", e);
                }
            }
            return prop;
        }

        public static String getURL() {
            String url = null;
            if (getConfig().getProperty("url") != null) {
                url = getConfig().getProperty("url");
            }
            return url;
        }

        public static String getPrivateKey() {
            String key = null;
            if (getConfig().getProperty("key") != null) {
                key = getConfig().getProperty("key");
            }
            return key;
        }

        public static String getPart() {
            String part = null;
            if (getConfig().getProperty("part") != null) {
                part = getConfig().getProperty("part");
            }
            return part;
        }
    }

}
