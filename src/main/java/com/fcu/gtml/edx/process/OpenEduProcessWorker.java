package com.fcu.gtml.edx.process;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpenEduProcessWorker {
    private static final Logger L = LogManager.getLogger();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OpenEduProcessWorker worker = new OpenEduProcessWorker();
        Command command = worker.parserComand(args);
        if (command == null) {
            L.warn("No Command, End");
        }

        switch (command.getType()) {
        case COURSE:
            
            break;
        case STUDENT:
            
            break;
        case VIDEO:
            
            break;
        default:
            L.warn("no such command: {}", command);
            break;
        }
    }

    /**
     * 解析任務參數
     * @param args
     * @return
     */
    private Command parserComand(String[] args) {
        Command command = new Command();
        for (int i = 0; i < args.length; i++) {
            String key = args[i].trim();
//            String value = "";
//            if (args.length != 1) {
//                value = args[++i].trim();
//            }
            switch (key) {
            case "-course":
                command.setType(Command.CommandType.COURSE);
                break;
            case "-student":
                command.setType(Command.CommandType.STUDENT);
                break;
            case "-video":
                command.setType(Command.CommandType.VIDEO);
                break;
            default:
                L.warn(key + " is not recognized as an internal or external command");
                System.out.println(key + " is not recognized as an internal or external command");
                return null;
            }
        }
        System.out.println(ArrayUtils.toString(args) + " is not recognized as an internal or external command");
        return null;
    }

    public static class Command {
        public enum CommandType {
            COURSE, STUDENT, VIDEO
        }
        CommandType type;
        int days;
        public CommandType getType() {
            return type;
        }
        public void setType(CommandType type) {
            this.type = type;
        }
        public int getDays() {
            return days;
        }
        public void setDays(int days) {
            this.days = days;
        }
    }
}
