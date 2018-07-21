package problem6_strategy_pattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getName().length() == p2.getName().length()){
            return String.valueOf(p1.getName().charAt(0)).compareToIgnoreCase(String.valueOf(p2.getName().charAt(0)));
        }
        return p1.getName().length() - p2.getName().length();
    }
}
