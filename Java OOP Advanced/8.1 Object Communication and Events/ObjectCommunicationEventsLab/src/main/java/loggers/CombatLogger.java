package loggers;

import enums.LogType;

public class CombatLogger extends Logger {

    @Override
    public void handle(LogType logType, String s) {
        if(logType == LogType.ATTACK || logType == LogType.MAGIC){
            System.out.println(logType.name() + ": " + s);
        } else {
            super.passToSuccessor(logType, s);
        }
    }
}
