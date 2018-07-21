package problem2_warning_levels;

public class Message {
    private Importance importance;
    private String message;

    public Message(String importance, String message) {
        this.importance = Enum.valueOf(Importance.class, importance.toUpperCase());
        this.message = message;
    }

    public Importance getImportance() {
        return this.importance;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.getImportance() + ": " + this.getMessage();
    }
}
