import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BubbleTests {
    @Test
    public void bubbleSortOrdersStrings(){
        List<String> testList = new ArrayList<String>(){{
            add("asd");
            add("Pesho");
            add("Gosho");
        }};
        Bubble.sort(testList);
        Assert.assertEquals("asd", testList.get(2));
        Assert.assertEquals("Gosho", testList.get(0));
        Assert.assertEquals("Pesho", testList.get(1));
    }

    @Test
    public void bubbleSortOrdersIntegers(){
        List<Integer> testList = new ArrayList<>(){{
            add(2);
            add(3);
            add(1);
        }};
        Bubble.sort(testList);
        Assert.assertEquals(Integer.valueOf(1), testList.get(0));
        Assert.assertEquals(Integer.valueOf(2), testList.get(1));
        Assert.assertEquals(Integer.valueOf(3), testList.get(2));
    }

}
