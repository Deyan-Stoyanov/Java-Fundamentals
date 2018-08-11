package implementations.appenders;

import abstractions.Appender;
import abstractions.File;
import abstractions.Layout;
import enums.ReportLevel;

public abstract class BaseAppender implements Appender {
    private File file;
    private Layout layout;
    private int messagesCount;
    private ReportLevel reportLevel;

    protected BaseAppender(Layout layout){
        this.layout = layout;
        this.messagesCount = 0;
        reportLevel = null;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    public int getMessagesCount() {
        return this.messagesCount;
    }

    public void increaseMessageCount(){
        this.messagesCount++;
    }

    @Override
        public String toString() {
            return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                    this.getClass().getSimpleName(), this.getLayout().getClass().getSimpleName(), this.getReportLevel() == null ? ReportLevel.INFO.name() : this.getReportLevel().name(),  this.getMessagesCount());
        }
}
