package implementations.appenders;

import abstractions.Layout;
import enums.ReportLevel;
import implementations.files.LogFile;

public class FileAppender extends BaseAppender{
    public FileAppender(Layout layout) {
        super(layout);
        this.setFile(new LogFile());
    }

    public void append(String dateTime, String level, String message) {
        if(this.getReportLevel() == null){
            super.getFile().write(this.getLayout().layoutString(dateTime, level, message));
            this.increaseMessageCount();
        } else {
            if(this.getReportLevel().ordinal() <= Enum.valueOf(ReportLevel.class, level).ordinal()){
                super.getFile().write(this.getLayout().layoutString(dateTime, level, message));
                this.increaseMessageCount();
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.getFile().getSize();
    }
}
