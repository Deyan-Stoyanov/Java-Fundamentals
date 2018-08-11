import abstractions.Appender;
import abstractions.File;
import abstractions.Layout;
import abstractions.Logger;
import enums.ReportLevel;
import factory.AppenderFactory;
import factory.LayoutFactory;
import implementations.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int appendersCount = Integer.parseInt(reader.readLine());
        Appender[] appenders = getAppenders(reader, appendersCount);
        Logger logger = new MessageLogger(appenders);
        String command;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] commandData = command.split("\\|");
            logMessage(logger, commandData);
        }
        System.out.println("Logger info");
        for (Appender appender : appenders) {
            System.out.println(appender.toString());
        }
    }

    private static Appender[] getAppenders(BufferedReader reader, int appendersCount) throws IOException {
        Appender[] appenders = new Appender[appendersCount];
        for (int i = 0; i < appendersCount; i++) {
            String[] data = reader.readLine().split("\\s+");
            try {
                Layout layout = LayoutFactory.createLayout(data[1]);
                Appender appender = AppenderFactory.createAppender(data[0], layout);
                if(data.length == 3){
                    ReportLevel reportLevel = Enum.valueOf(ReportLevel.class, data[2]);
                    appender.setReportLevel(reportLevel);
                }
                appenders[i] = appender;
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return appenders;
    }

    private static void logMessage(Logger logger, String[] commandData) {
        String level = commandData[0];
        String dateTime = commandData[1];
        String message = commandData[2];
        switch (level){
            case "INFO":
                logger.logInfo(dateTime, message);
                break;
            case "WARNING":
                logger.logWarning(dateTime, message);
                break;
            case "FATAL":
                logger.logFatal(dateTime, message);
                break;
            case "CRITICAL":
                logger.logCritical(dateTime, message);
                break;
            case "ERROR":
                logger.logError(dateTime, message);
                break;
                default:break;
        }
    }
}
