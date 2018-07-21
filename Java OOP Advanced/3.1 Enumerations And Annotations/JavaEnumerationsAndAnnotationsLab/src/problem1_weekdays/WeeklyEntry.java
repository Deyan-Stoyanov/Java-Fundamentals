package problem1_weekdays;

import java.util.Comparator;

public class WeeklyEntry {
    public static final Comparator<WeeklyEntry> WEEKLY_ENTRY_COMPARATOR = getComparator();
    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return this.weekday;
    }

    public String getNotes() {
        return this.notes;
    }

    @Override
    public String toString() {
        return this.getWeekday().toString() + " - " + this.getNotes();
    }

    private static Comparator<WeeklyEntry> getComparator(){
        return Comparator.comparingInt(e -> e.weekday.ordinal());
    }
}
