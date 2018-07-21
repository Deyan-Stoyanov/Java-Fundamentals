package problem7_equality_logic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.hashCode() - o2.hashCode();
    }
}
