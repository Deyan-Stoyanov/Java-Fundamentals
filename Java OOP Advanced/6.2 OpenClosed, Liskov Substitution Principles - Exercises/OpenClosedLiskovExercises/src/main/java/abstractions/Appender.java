package abstractions;

import enums.ReportLevel;

public interface Appender {
    void append(String dateTime, String level, String message);

    File getFile();

    void setFile(File file);

    Layout getLayout();

    void setLayout(Layout layout);

    void setReportLevel(ReportLevel reportLevel);

    ReportLevel getReportLevel();

    int getMessagesCount();

    void increaseMessageCount();
}
