package implementations.loggers;

import abstractions.Appender;
import abstractions.Logger;
import enums.ReportLevel;

public class MessageLogger implements Logger {
    private Appender[] appenders;
    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    public void logError(String time, String message) {
        for (Appender appender : appenders) {
            appender.append(time, ReportLevel.ERROR.name(), message);
        }
    }

    public void logInfo(String time, String message) {
        for (Appender appender : appenders) {
            appender.append(time, ReportLevel.INFO.name(), message);
        }
    }

    public void logWarning(String time, String message) {
        for (Appender appender : appenders) {
            appender.append(time, ReportLevel.WARNING.name(), message);
        }
    }

    public void logFatal(String time, String message) {
        for (Appender appender : appenders) {
            appender.append(time, ReportLevel.FATAL.name(), message);
        }
    }

    public void logCritical(String time, String message) {
        for (Appender appender : appenders) {
            appender.append(time, ReportLevel.CRITICAL.name(), message);
        }
    }
}
