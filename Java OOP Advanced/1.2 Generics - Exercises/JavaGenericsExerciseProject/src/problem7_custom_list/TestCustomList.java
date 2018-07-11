package problem7_custom_list;

import org.junit.*;

import static org.junit.Assert.*;

public class TestCustomList {

    @Test
    public void testMaxElement() {
        MyList<Integer> customList = new MyList<>();
        for (int i = 0; i < 100; i++) {
            customList.add(i);
            customList.add(null);
        }

        Integer expected = 99;
        assertEquals(expected, customList.getMax());
    }

    @Test
    public void testMinElement() {
        MyList<Integer> customList = new MyList<>();
        Integer expected = -1000;
        for (int i = -1000; i <= 10000; i++) {
            customList.add(i);
        }

        assertEquals(expected, customList.getMin());
    }

    @Test
    public void removeElements() {
        MyList<Integer> customList = new MyList<>();
        Integer expected = 10000;
        for (int i = 0; i <= 10000; i++) {
            customList.add(i);
        }

        for (int i = 0; i <= 500; i++) {
            customList.remove(i);
        }

        assertEquals(expected, customList.getMax());
    }

    @Test
    public void contains() {
        MyList<Integer> customList = new MyList<>();
        for (int i = 0; i <= 10000; i++) {
            customList.add(i);
        }

        assertFalse(customList.contains(113144));
    }
}