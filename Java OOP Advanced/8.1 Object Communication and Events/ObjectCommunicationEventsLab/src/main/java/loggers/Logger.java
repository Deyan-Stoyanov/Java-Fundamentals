package loggers;

import abstractions.Handler;
import enums.LogType;

public abstract class Logger implements Handler {
    private Handler successor;

    protected Logger() { }

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }

    protected void passToSuccessor(LogType type, String message){
        if(this.successor != null){
            this.successor.handle(type, message);
        }
    }
}
