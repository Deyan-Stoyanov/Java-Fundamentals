package implementations.appenders;

import abstractions.Layout;
import enums.ReportLevel;

public class ConsoleAppender extends BaseAppender{

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public void append(String dateTime, String level, String message) {
        if(this.getReportLevel() == null){
            System.out.println(this.getLayout().layoutString(dateTime, level, message));
            this.increaseMessageCount();
        } else {
            if(this.getReportLevel().ordinal() <= Enum.valueOf(ReportLevel.class, level).ordinal()){
                System.out.println(this.getLayout().layoutString(dateTime, level, message));
                this.increaseMessageCount();
            }
        }
    }
}
