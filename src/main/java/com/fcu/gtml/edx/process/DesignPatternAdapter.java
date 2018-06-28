package com.fcu.gtml.edx.process;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fcu.gtml.edx.service.CallOutSiteAPIService;

public class DesignPatternAdapter {
    private static final Logger L = LogManager.getLogger();
    @Resource
    private CallOutSiteAPIService service;

    public void start() {
        List<String> words = service.listKeyIds();
        L.info("AAAAA:{}", words);
    }
}
