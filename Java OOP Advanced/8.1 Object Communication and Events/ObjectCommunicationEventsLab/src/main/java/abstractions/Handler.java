package abstractions;

import enums.LogType;

public interface Handler {
    void handle(LogType logType, String s);
    void setSuccessor(Handler handler);
}
