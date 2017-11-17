package com.fcu.gtml.edx.task;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.util.ErrorHandler;

//import com.newegg.autopricing.commons.Mails;

public class TaskErrorHandler implements ErrorHandler {

    private static final Logger L = LoggerFactory.getLogger(TaskErrorHandler.class);

    private static final String mailFrom = "autopricing-trigger@newegg.com";
    private static final String[] mailTo = { "gp.team.autopricing.dp@newegg.com" };

    @Override
    public void handleError(Throwable e) {
        String subject = "(Error) Schedule Exception";
        StringBuilder sb = new StringBuilder();
        String errorId = new DateTime().toString("yyyy/MM/dd-HH:mm:ss") + "-" + RandomStringUtils.randomNumeric(10);
        sb.append("Error ID: ").append(errorId);
        L.error(sb.toString(), e);
        sb.append("<br/>Exception:<br/>").append(ExceptionUtils.getStackTrace(e));
        String[] mailTo = TaskErrorHandler.mailTo;
        if (e instanceof DataAccessException) { //DB 相關exception 給 john
            mailTo = ArrayUtils.add(mailTo, "John.H.Huang@newegg.com");
        }
//        Mails.send(mailFrom, mailTo, subject, sb.toString());
    }

}
