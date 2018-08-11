package implementations.layouts;

import abstractions.Layout;

public class SimpleLayout implements Layout {
    public String layoutString(String dateTime, String level, String message){
        return String.format("%s - %s - %s", dateTime, level, message);
    }
}
