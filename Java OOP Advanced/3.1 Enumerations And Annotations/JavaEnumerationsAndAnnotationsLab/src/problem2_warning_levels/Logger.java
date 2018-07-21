package problem2_warning_levels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> messages;
    private Importance importanceLevel;

    public Logger(String importance) {
        this.importanceLevel = Enum.valueOf(Importance.class, importance.toUpperCase());
        this.messages = new ArrayList<>();
    }

    public void addMessage(String importance, String message){
        Importance imp = Enum.valueOf(Importance.class, importance.toUpperCase());
        if(imp.compareTo(this.importanceLevel) >= 0){
            this.messages.add(new Message(importance, message));
        }
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }
}
