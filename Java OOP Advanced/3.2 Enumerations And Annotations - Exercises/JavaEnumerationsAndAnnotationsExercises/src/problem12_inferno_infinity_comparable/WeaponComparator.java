package problem12_inferno_infinity_comparable;

import java.util.Comparator;

public class WeaponComparator implements Comparator<Weapons> {
    @Override
    public int compare(Weapons w1, Weapons w2) {
        return Double.compare(w1.getItemLevel(), w2.getItemLevel());
    }
}
