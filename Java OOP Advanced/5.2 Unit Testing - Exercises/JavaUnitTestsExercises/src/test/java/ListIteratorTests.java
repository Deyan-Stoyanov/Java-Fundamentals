import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {
    ListIterator listIterator;
    @Before
    public void init() throws OperationNotSupportedException {
        listIterator = new ListIterator("asd", "Pesho", "Gosho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void listShouldNotContainNullObjects() throws OperationNotSupportedException {
        listIterator = new ListIterator("asd", null, "Pesho");
    }

    @Test
    public void hasNextMethodReturnsTrue(){
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void moveMethodMovesTheCursor(){
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void printMethodThrowsExceptionWhenListEmpty() throws OperationNotSupportedException {
        ListIterator newListIterator = new ListIterator();
        newListIterator.print();
    }

    @Test
    public void printMethodPrintsGivenIndex() throws OperationNotSupportedException {
        listIterator.move();
        listIterator.print();
    }
}
