package implementations.layouts;

import abstractions.Layout;

public class XmlLayout implements Layout {
    public String layoutString(String dateTime, String level, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("<log>").append(System.lineSeparator())
                .append("\t<date>").append(dateTime).append("</date>").append(System.lineSeparator())
                .append("\t<level>").append(level).append("</level>").append(System.lineSeparator())
                .append("\t<message>").append(message).append("</message>").append(System.lineSeparator())
                .append("</log>");
        return sb.toString();
    }
}
