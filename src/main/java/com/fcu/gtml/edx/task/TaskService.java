package com.fcu.gtml.edx.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//import com.newegg.autopricing.commons.Mails;

@Component
public class TaskService {

    private final static Logger L = LoggerFactory.getLogger(TaskService.class);
    private final static List<Task> runningTasks = Collections.synchronizedList(new ArrayList<Task>());

    private String mailFrom = "autopricing-trigger@newegg.com";
    private String[] mailTo = new String[] { "gp.team.autopricing.dp@newegg.com" };

    List<Task> getRunningTasks() {
        return runningTasks;
    }

    void addRunningTask(Task task) {
        L.info("runningTask: {}", task.getName());
        runningTasks.add(task);
    }

    void removeRunningTask(Task task) {
        L.info("remove runningTask: {}", task.getName());
        runningTasks.remove(task);
    }

    boolean runTask(final Task task) {
        //保障執行緒安全(thread-safe)
        synchronized (runningTasks) {
            if (runningTasks.contains(task)){
                return false;
            }
        }

        new Thread() {
            public void run() {
                try {
                    L.info("Triger Task " + task.getName() + " start.");
                    task.execute();
                    L.info("Triger Task " + task.getName() + " end.");
//                    Mails.send(mailFrom, mailTo , "Triger Task" + task.getName(), "Success.");
                } catch (Exception e) {
//                    Mails.send(mailFrom, mailTo , "Triger Task" + task.getName(), ExceptionUtils.getStackTrace(e));
                    L.error("Triger Task Error " + task.getName(), e);
                } finally {
                    removeRunningTask(task);
                }
            };
        }.start();
        return true;
    }

}
