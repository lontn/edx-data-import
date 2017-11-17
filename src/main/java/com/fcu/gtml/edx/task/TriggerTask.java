package com.fcu.gtml.edx.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

public class TriggerTask extends AbstractTask{
    private static final Logger L = LogManager.getLogger();

    private String countryCode;
    private String[] websites;
    private int[] groups;
    private String[] runRateQtys;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String[] getWebsites() {
        return websites;
    }

    public void setWebsites(String[] websites) {
        this.websites = websites;
    }

    public int[] getGroups() {
        return groups;
    }

    public void setGroups(int[] groups) {
        this.groups = groups;
    }

    public String[] getRunRateQtys() {
        return runRateQtys;
    }

    public void setRunRateQtys(String[] runRateQtys) {
        this.runRateQtys = runRateQtys;
    }

    @Override
    public void runTask() {
        DateTime dt = new DateTime();
        L.info(dt.toString("yyyy-MM-dd HH:mm:ss") + " " + getName() + " Start......");
        L.info(dt.toString("yyyy-MM-dd HH:mm:ss") + " " + "Welcome groups:{}, runRateQtys:{}", groups, runRateQtys);
        L.info(dt.toString("yyyy-MM-dd HH:mm:ss") + " " + getName() + " END........");
    }

}
