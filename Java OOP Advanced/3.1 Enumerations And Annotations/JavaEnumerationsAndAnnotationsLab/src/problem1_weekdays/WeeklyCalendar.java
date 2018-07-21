package problem1_weekdays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeeklyCalendar {
    private List<WeeklyEntry> weeklySchedule;

    public WeeklyCalendar() {
        this.weeklySchedule = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes){
        try {
            this.weeklySchedule.add(new WeeklyEntry(weekday, notes));
        } catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
        }
    }

    public Iterable<WeeklyEntry> getWeeklySchedule(){
        return this.weeklySchedule.stream().sorted(WeeklyEntry.WEEKLY_ENTRY_COMPARATOR).collect(Collectors.toCollection(ArrayList::new));
    }
}
