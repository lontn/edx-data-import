package com.fcu.gtml.edx.task;

import java.lang.management.ManagementFactory;

import javax.annotation.Resource;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.slf4j.Logger;



/**
 * 排程任務
 * 
 * @since $Id$
 */
public abstract class AbstractTask implements Task{

    private String name;
    private boolean running = false;
    @Resource
    private TaskService taskService;

    public AbstractTask() {
        this.name = getClass().getSimpleName();
    }

    public abstract void runTask();
    
    @Override
    public void execute(){
        running = true;
        taskService.addRunningTask(this);
        runTask();
        taskService.removeRunningTask(this);
        running = false;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRunning() {
        return running;
    }

    public void logMemoryStatus(Logger L) {
        try {
            Runtime runtime = Runtime.getRuntime();
            String maxMemory = String.format("%,d M", runtime.maxMemory() / 1000000);
            String totalMemory = String.format("%,d M", runtime.totalMemory() / 1000000);
            String freeMemory = String.format("%,d M", runtime.freeMemory() / 1000000);
            MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
            ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
            AttributeList list = mbs.getAttributes(name, new String[]{ "ProcessCpuLoad" });
            String cpuUsage = "";
            if (!list.isEmpty()) {
                Attribute att = (Attribute)list.get(0);
                Double value  = (Double)att.getValue();
                if (value != -1.0) {
                    cpuUsage = "" + ((int)(value * 1000) / 10.0);
                }
            }
            L.info("Memory: [Max : " + maxMemory + "]" + " [Total : " + totalMemory + "]" + " [Free : " + freeMemory + "]" + " ,CPU : ["+ cpuUsage+ "]");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
